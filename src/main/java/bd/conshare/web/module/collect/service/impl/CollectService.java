package bd.conshare.web.module.collect.service.impl;

import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.Query;
import bd.conshare.core.bean.QueryOrder;
import bd.conshare.core.common.service.ServiceBase;
import bd.conshare.core.utils.bookmarks.BookMark;
import bd.conshare.core.utils.bookmarks.BookMarks;
import bd.conshare.web.module.collect.dao.ICollectDao;
import bd.conshare.web.module.collect.domain.Collect;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import bd.conshare.web.module.collect.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/1, All Rights Reserved.
 * http://beldon.me
 */
@Service
public class CollectService extends ServiceBase implements ICollectService {

    @Autowired
    private ICollectDao collectDao;

    @Autowired
    private ICollectCategoryService collectCategoryService;

    @Override
    public Optional<Collect> findById(String id) {
        Assert.notNull(id, "id can not be null");
        Collect collect = collectDao.selectByPrimaryKey(id);
        return Optional.ofNullable(collect);
    }

    @Override
    public Optional<Collect> addSave(Collect collect) {
        Assert.notNull(collect, "collect can not be null");
        Assert.notNull(collect.getUid(), "uid can not be null");
        Assert.notNull(collect.getUrl(), "url can not be null");
        collect.setCreTime(new Date());
        collectDao.insertSelective(collect);
        return Optional.of(collect);
    }

    @Override
    public Optional<Collect> editSave(Collect collect) {
        Assert.notNull(collect, "collect can not be null");
        Assert.notNull(collect.getId(), "id can not be null");
        Assert.notNull(collect.getUrl(), "url can not be null");
        collectDao.updateByPrimaryKeySelective(collect);
        return Optional.of(collect);
    }

    @Override
    public Page<Collect> findByPage(Page<Collect> page, String uid, String catId) {
        Assert.notNull(page, "page can not be null");
        Collect example = new Collect();
        if (StringUtils.hasText(uid)) {
            example.setUid(uid);
        }
        if (StringUtils.hasText(catId)) {
            example.setCategoryId(catId);
            collectDao.query(page, Query.create().domain(example).order(QueryOrder.desc("cre_time")));
        } else {
            page = findDefaultCategoryCollect(page, uid);
        }
        return page;
    }

    @Override
    public Page<Collect> findDefaultCategoryCollect(Page<Collect> page, String uid) {
        Assert.notNull(page, "page can not be null");
        Assert.notNull(uid, "uid can not be null");
        collectDao.findDefaultCategoryCollect(page, uid);
        return page;
    }

    @Override
    public void moveCategory(String catId, String targetCatId) {
        Assert.notNull(catId, "category's id can not be null");
        collectDao.moveCategory(catId, targetCatId);
    }

    @Override
    public void delete(String id) {
        Assert.notNull(id, "id can not be null");
        collectDao.deleteByPrimaryKey(id);
    }

    @Override
    public void importBookMarks(String uid, List<BookMarks> bookMarksList) {
        if (bookMarksList != null && StringUtils.hasText(uid)) {
            for (BookMarks bookMarks : bookMarksList) {
                String categoryName = bookMarks.getCategoryName().trim();
                String categoryId = null;
                if (StringUtils.hasText(categoryName)) {
                    Optional<CollectCategory> categoryOptional = collectCategoryService.findOrNewByName(uid, categoryName);
                    if (categoryOptional.isPresent()) {
                        categoryId = categoryOptional.get().getId();
                    }
                }
                List<BookMark> marks = bookMarks.getBookMarks();
                if (marks != null) {
                    for (BookMark mark : marks) {
                        if (StringUtils.hasText(mark.getUrl())) {
                            Collect example = new Collect();
                            example.setUrl(mark.getUrl());
                            List<Collect> list = collectDao.query(Query.create().domain(example));
                            if (list == null || list.size() == 0) {
                                example.setUid(uid);
                                example.setTitle(mark.getTitle());
                                example.setFavicon(mark.getIcon());
                                example.setCreTime(mark.getAddDate());
                                example.setCategoryId(categoryId);
                                collectDao.insertSelective(example);
                            }else{
                                for (Collect collect : list) {
                                    collect.setUid(uid);
                                    collect.setTitle(mark.getTitle());
                                    collect.setFavicon(mark.getIcon());
                                    collect.setCreTime(mark.getAddDate());
                                    collect.setCategoryId(categoryId);
                                    collectDao.updateByPrimaryKeySelective(collect);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}

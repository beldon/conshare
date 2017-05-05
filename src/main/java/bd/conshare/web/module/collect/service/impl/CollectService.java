package bd.conshare.web.module.collect.service.impl;

import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.Query;
import bd.conshare.core.bean.QueryOrder;
import bd.conshare.core.common.service.ServiceBase;
import bd.conshare.web.module.collect.dao.ICollectDao;
import bd.conshare.web.module.collect.domain.Collect;
import bd.conshare.web.module.collect.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
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
        }
        collectDao.query(page, Query.create().domain(example).order(QueryOrder.desc("cre_time")));
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

}

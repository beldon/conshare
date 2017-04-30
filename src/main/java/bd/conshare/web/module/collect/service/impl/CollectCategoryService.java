package bd.conshare.web.module.collect.service.impl;

import bd.conshare.core.bean.Query;
import bd.conshare.core.common.service.ServiceBase;
import bd.conshare.web.module.collect.dao.ICollectCategoryDao;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
@Service
public class CollectCategoryService extends ServiceBase implements ICollectCategoryService {

    @Autowired
    private ICollectCategoryDao collectCategoryDao;

    @Override
    public Optional<CollectCategory> addSave(String uid, String name) {
        Assert.notNull(uid, "uid can not be null");
        Assert.notNull(name, "name can not be null");
        CollectCategory collectCategory = new CollectCategory();
        collectCategory.setUid(uid);
        collectCategory.setName(name);
        return addSave(collectCategory);
    }

    @Override
    public Optional<CollectCategory> addSave(CollectCategory collectCategory) {
        Assert.notNull(collectCategory, "entity can no be null");
        Assert.notNull(collectCategory.getUid(), "uid can not be null");
        Assert.notNull(collectCategory.getName(), "name can not be null");
        Optional<CollectCategory> collectCategoryOptional = findByName(collectCategory.getUid(), collectCategory.getName());
        if (!collectCategoryOptional.isPresent()) {
            collectCategoryDao.insertSelective(collectCategory);
            collectCategoryOptional = Optional.of(collectCategory);
        }
        return collectCategoryOptional;
    }

    @Override
    public boolean isExist(String uid, String name) {
        return findByName(uid, name).isPresent();
    }

    @Override
    public void changeName(String catId, String newName) {
        CollectCategory category = new CollectCategory();
        category.setId(catId);
        category.setName(newName);
        collectCategoryDao.updateByPrimaryKeySelective(category);

    }

    @Override
    public Optional<CollectCategory> editSave(CollectCategory collectCategory) {
        Assert.notNull(collectCategory, "entity can no be null");
        Assert.notNull(collectCategory.getId(), "id can not be null");
        Assert.notNull(collectCategory.getUid(), "uid can not be null");
        Assert.notNull(collectCategory.getName(), "name can not be null");
        collectCategoryDao.updateByPrimaryKeySelective(collectCategory);
        return Optional.of(collectCategory);
    }

    @Override
    public Optional<CollectCategory> findById(String id) {
        Assert.notNull(id, "id can not be null");
        CollectCategory collectCategory = collectCategoryDao.selectByPrimaryKey(id);
        return Optional.of(collectCategory);
    }

    @Override
    public Optional<CollectCategory> findByName(String uid, String name) {
        Assert.notNull(uid, "uid can not be null");
        Assert.notNull(name, "name can not be null");
        CollectCategory example = new CollectCategory();
        example.setUid(uid);
        example.setName(name);
        List<CollectCategory> list = collectCategoryDao.query(Query.create().domain(example));
        if (list != null && list.size() > 0) {
            return Optional.of(list.get(0));
        }
        return Optional.empty();
    }

    @Override
    public List<CollectCategory> getAllCategory(String uid) {
        CollectCategory example = new CollectCategory();
        example.setUid(uid);
        return collectCategoryDao.query(Query.create().domain(example));
    }
}

package bd.conshare.web.module.collect.service.impl;

import bd.conshare.core.common.service.ServiceBase;
import bd.conshare.web.module.collect.dao.ICollectCategoryDao;
import bd.conshare.web.module.collect.domain.CollectCategory;
import bd.conshare.web.module.collect.service.ICollectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void insert() {
        CollectCategory collectCategory = new CollectCategory();
        collectCategory.setName("name");
        collectCategory.setUid("11111");
        collectCategoryDao.insertSelective(collectCategory);

    }
}

package bd.conshare.web.module.collect.service.impl;

import bd.conshare.core.common.service.ServiceBase;
import bd.conshare.web.module.collect.dao.ICollectDao;
import bd.conshare.web.module.collect.domain.Collect;
import bd.conshare.web.module.collect.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    public Optional<Collect> addSave(Collect collect) {
        Assert.notNull(collect, "collect can not be null");
        Assert.notNull(collect.getUid(), "uid can not be null");
        Assert.notNull(collect.getUrl(), "url can not be null");
        collect.setCreTime(new Date());
        collectDao.insertSelective(collect);
        return Optional.of(collect);
    }

}

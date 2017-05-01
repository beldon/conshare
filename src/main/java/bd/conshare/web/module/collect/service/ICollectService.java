package bd.conshare.web.module.collect.service;

import bd.conshare.web.module.collect.domain.Collect;

import java.util.Optional;

/**
* 用户收藏表
* Created by .
* Copyright (c) 2017-04-30, All Rights Reserved.
* http://beldon.me
*/
public interface ICollectService {

    /**
     * 添加保存
     * @param collect 收藏实体类
     * @return
     */
    Optional<Collect> addSave(Collect collect);
}

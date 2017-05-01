package bd.conshare.web.module.collect.service;

import bd.conshare.core.bean.Page;
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
     *
     * @param collect 收藏实体类
     * @return
     */
    Optional<Collect> addSave(Collect collect);

    /**
     * 分页查找收藏
     *
     * @param page  分页实体
     * @param uid   用户id
     * @param catId 分类id，可为空
     * @return
     */
    Page<Collect> findByPage(Page<Collect> page, String uid, String catId);
}

package bd.conshare.web.module.collect.service;

import bd.conshare.web.module.collect.domain.CollectCategory;

import java.util.List;
import java.util.Optional;

/**
 * 云收藏分类表
 * Created by .
 * Copyright (c) 2017-04-30, All Rights Reserved.
 * http://beldon.me
 */
public interface ICollectCategoryService {

    /**
     * 添加一个分类
     *
     * @param uid  用户id
     * @param name 分类名称
     * @param sort 排序
     * @return
     */
    Optional<CollectCategory> addSave(String uid, String name, Integer sort);

    /**
     * 添加一个分类
     *
     * @param collectCategory 分类实体
     * @return
     */
    Optional<CollectCategory> addSave(CollectCategory collectCategory);


    /**
     * 判断分类名称是否存在
     *
     * @param uid  用户id
     * @param name 分类名称
     * @return true-存在， false-不存在
     */
    boolean isExist(String uid, String name);


    /**
     * 修改分类名称
     *
     * @param catId   分类id
     * @param newName 新名称
     * @return
     */
    void changeName(String catId, String newName);


    /**
     * 修改保存
     *
     * @param collectCategory
     * @return
     */
    Optional<CollectCategory> editSave(CollectCategory collectCategory);

    /**
     * 根据id查找分类
     *
     * @param id 分类id
     * @return
     */
    Optional<CollectCategory> findById(String id);

    /**
     * 根据分类名称去获取分类
     *
     * @param uid  用户id
     * @param name 分类名称
     * @return
     */
    Optional<CollectCategory> findByName(String uid, String name);

    /**
     * 查找或新增一个类目
     *
     * @param uid  用户id
     * @param name 类目名称
     * @return
     */
    Optional<CollectCategory> findOrNewByName(String uid, String name);


    /**
     * 获取用户所有分类
     *
     * @param uid 用户id
     * @return
     */
    List<CollectCategory> getAllCategory(String uid);

    /**
     * 删除分类
     *
     * @param id 分类id
     */
    void delete(String id);

}

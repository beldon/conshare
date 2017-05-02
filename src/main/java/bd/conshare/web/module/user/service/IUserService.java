package bd.conshare.web.module.user.service;

import bd.conshare.web.module.user.domain.User;

import java.util.Optional;

/**
 * 用户主表
 * Created by .
 * Copyright (c) 2017-05-02, All Rights Reserved.
 * http://beldon.me
 */
public interface IUserService {
    /**
     * 注册用户
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    Optional<User> register(String account, String password);


    /**
     * 根据账号查找用户
     *
     * @param account 账号
     * @return
     */
    Optional<User> findByAccount(String account);

    /**
     * 根据用户id去查找用户
     *
     * @param uid 用户id
     * @return
     */
    Optional<User> findByUid(String uid);

    /**
     * 检查账号是否存在
     *
     * @param account 账号
     * @return
     */
    boolean checkAccountExit(String account);


    /**
     * 加密密码，统一加密路径
     *
     * @param password 密码
     * @return
     */
    String encodePassword(String password);


    /**
     * 校验密码是否正常
     *
     * @param rawPassword     源码密码
     * @param encodedPassword 加密后的密码
     * @return
     */
    boolean matches(String rawPassword, String encodedPassword);
}

package bd.conshare.web.module.user.service.impl;

import bd.conshare.core.bean.Query;
import bd.conshare.core.common.service.ServiceBase;
import bd.conshare.web.module.user.dao.IUserDao;
import bd.conshare.web.module.user.dao.IUserProfileDao;
import bd.conshare.web.module.user.domain.User;
import bd.conshare.web.module.user.domain.UserProfile;
import bd.conshare.web.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/2, All Rights Reserved.
 * http://beldon.me
 */
@Service
public class UserService extends ServiceBase implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserProfileDao userProfileDao;

    @Autowired
    private StandardPasswordEncoder standardPasswordEncoder;


    @Override
    public Optional<User> register(String account, String password) {
        Assert.notNull(account,"账号不能为空");
        Assert.notNull(password, "密码不能为空");
        User user = new User();
        user.setAccount(account);
        user.setNickname(account);
        user.setUid(account);
        user.setPassword(encodePassword(password));
        user.setRegTime(new Date());
        userDao.insertSelective(user);
        UserProfile profile = new UserProfile();
        profile.setUid(user.getUid());
        userProfileDao.insertSelective(profile);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByAccount(String account) {
        Assert.notNull(account, "account can not be null");
        User user = new User();
        user.setAccount(account);
        List<User> userList = userDao.query(Query.create().domain(user));
        if (userList != null && userList.size() > 0) {
            return Optional.of(userList.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUid(String uid) {
        Assert.notNull(uid, "uid can not be null");
        User user = userDao.selectByPrimaryKey(uid);
        return Optional.of(user);
    }

    @Override
    public boolean checkAccountExit(String account) {
        return findByAccount(account).isPresent();
    }

    @Override
    public String encodePassword(String password) {
        if (StringUtils.hasText(password)) {
            return standardPasswordEncoder.encode(password);
        }
        return "";
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        if (StringUtils.hasText(rawPassword) && StringUtils.hasText(encodedPassword)) {
            return standardPasswordEncoder.matches(rawPassword, encodedPassword);
        }
        return false;
    }
}

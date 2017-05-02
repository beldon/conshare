package bd.conshare.web.module.user.service;

import bd.conshare.ConShareApplication;
import bd.conshare.web.module.user.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Beldon.
 * Copyright (c)  2017/5/2, All Rights Reserved.
 * http://beldon.me
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConShareApplication.class)
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void register() throws Exception {
        userService.register("beldon", "111111");
    }

    @Test
    public void findByAccount() throws Exception {
        Optional<User> user = userService.findByAccount("beldon");
        System.out.println(user);
    }

    @Test
    public void findByUid() throws Exception {
        Optional<User> user = userService.findByUid("b36b34732f3c11e788643085a91c3f22");
        System.out.println(user);
    }

    @Test
    public void encodePassword() throws Exception {
    }

    @Test
    public void matches() throws Exception {
    }

}
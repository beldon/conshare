package bd.conshare.web.module.collect.service;

import bd.conshare.ConShareApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.thymeleaf.spring4.SpringTemplateEngine;

import static org.junit.Assert.*;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ConShareApplication.class)
//@ConditionalOnClass(SpringTemplateEngine.class)
//@Configuration
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConShareApplication.class)
public class ICollectCategoryServiceTest {

    @Autowired
    private ICollectCategoryService collectCategoryService;

    @Test
    public void insert() throws Exception {
        collectCategoryService.insert();
    }

}
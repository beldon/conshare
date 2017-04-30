package bd.conshare.web.module.collect.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

/**
* 用户收藏表
* Created by .
* Copyright (c) 2017-04-30, All Rights Reserved.
* http://beldon.me
*/
public interface CollectService {
    int insert();
    int update();
    int delete(Long id);
}

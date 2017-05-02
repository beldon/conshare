package bd.conshare.web.module.user.dao;

import bd.conshare.web.module.user.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.Query;
import java.util.List;

/**
* 用户主表
* Created by Beldon.
* Copyright (c) 2017-05-02, All Rights Reserved.
* http://beldon.me
*/
@Repository
public interface IUserDao {

    int insert(User user);

    int insertSelective(User user);

    @Delete({
            "delete from t_user",
            "where uid = #{uid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String uid);

    int updateByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User user);

    @Select({
            "select * ",
            "from t_user",
            "where uid = #{uid,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    User selectByPrimaryKey(String uid);

    @ResultMap("BaseResultMap")
    List<User> query(@Param("query") Query query);

    @ResultMap("BaseResultMap")
    List<User> query(@Param("user") Page<User> page, @Param("query") Query query);

}

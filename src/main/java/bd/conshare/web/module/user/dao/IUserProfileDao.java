package bd.conshare.web.module.user.dao;

import bd.conshare.web.module.user.domain.UserProfile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.Query;
import java.util.List;

/**
* 用户副表
* Created by Beldon.
* Copyright (c) 2017-05-02, All Rights Reserved.
* http://beldon.me
*/
@Repository
public interface IUserProfileDao {

    int insert(UserProfile userProfile);

    int insertSelective(UserProfile userProfile);

    @Delete({
            "delete from t_user_profile",
            "where uid = #{uid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String uid);

    int updateByPrimaryKey(UserProfile userProfile);

    int updateByPrimaryKeySelective(UserProfile userProfile);

    @Select({
            "select * ",
            "from t_user_profile",
            "where uid = #{uid,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    UserProfile selectByPrimaryKey(String uid);

    @ResultMap("BaseResultMap")
    List<UserProfile> query(@Param("query") Query query);

    @ResultMap("BaseResultMap")
    List<UserProfile> query(@Param("userProfile") Page<UserProfile> page, @Param("query") Query query);

}

package bd.conshare.web.module.collect.dao;

import bd.conshare.web.module.collect.domain.Collect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.Query;
import java.util.List;

/**
* 用户收藏表
* Created by Beldon.
* Copyright (c) 2017-04-30, All Rights Reserved.
* http://beldon.me
*/
@Repository
public interface ICollectDao {

    int insert(Collect collect);

    int insertSelective(Collect collect);

    @Delete({
            "delete from t_collect",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(Collect collect);

    int updateByPrimaryKeySelective(Collect collect);

    @Select({
            "select * ",
            "from t_collect",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Collect selectByPrimaryKey(String id);

    @ResultMap("BaseResultMap")
    List<Collect> query(@Param("query") Query query);

    @ResultMap("BaseResultMap")
    List<Collect> query(@Param("collect") Page<Collect> page, @Param("query") Query query);


    @Update("UPDATE t_collect SET category_id = #{targetCatId} WHERE category_id = #{sourceCatId}")
    int moveCategory(@Param("sourceCatId") String sourceCatId, @Param("targetCatId") String targetCatId);
}

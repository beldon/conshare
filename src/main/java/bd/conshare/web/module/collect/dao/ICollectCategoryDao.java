package bd.conshare.web.module.collect.dao;

import bd.conshare.web.module.collect.domain.CollectCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import bd.conshare.core.bean.Page;
import bd.conshare.core.bean.Query;
import java.util.List;

/**
* 云收藏分类表
* Created by Beldon.
* Copyright (c) 2017-04-30, All Rights Reserved.
* http://beldon.me
*/
@Repository
public interface ICollectCategoryDao {

    int insert(CollectCategory collectCategory);

    int insertSelective(CollectCategory collectCategory);

    @Delete({
            "delete from t_collect_category",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(CollectCategory collectCategory);

    int updateByPrimaryKeySelective(CollectCategory collectCategory);

    @Select({
            "select * ",
            "from t_collect_category",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    CollectCategory selectByPrimaryKey(String id);

    @ResultMap("BaseResultMap")
    List<CollectCategory> query(@Param("query") Query query);

    @ResultMap("BaseResultMap")
    List<CollectCategory> query(@Param("collectCategory") Page<CollectCategory> page, @Param("query") Query query);

}

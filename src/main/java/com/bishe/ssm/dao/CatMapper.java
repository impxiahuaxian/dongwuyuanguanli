package com.bishe.ssm.dao;

import com.bishe.ssm.bean.Cat;
import com.bishe.ssm.bean.CatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CatMapper {
    long countByExample(CatExample example);

    int deleteByExample(CatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cat record);

    int insertSelective(Cat record);

    List<Cat> selectByExample(CatExample example);
    long countByExample();
    Cat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cat record, @Param("example") CatExample example);

    int updateByExample(@Param("record") Cat record, @Param("example") CatExample example);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);

    List<Cat> getAll();

    List<Cat> getByName(String catname);

}
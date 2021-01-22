package com.bishe.ssm.dao;

import com.bishe.ssm.bean.Horse;
import com.bishe.ssm.bean.HorseExample;
import java.util.List;

import com.bishe.ssm.bean.Manage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseMapper {
    long countByExample(HorseExample example);
    long countByExample();
    int deleteByExample(HorseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Horse record);

    int insertSelective(Horse record);

    List<Horse> selectByExample(HorseExample example);
    List<Horse> getByName(String horsename);
    List<Horse> getAll();

    Horse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Horse record, @Param("example") HorseExample example);

    int updateByExample(@Param("record") Horse record, @Param("example") HorseExample example);

    int updateByPrimaryKeySelective(Horse record);

    int updateByPrimaryKey(Horse record);
    
    List<Manage> getManage();

}
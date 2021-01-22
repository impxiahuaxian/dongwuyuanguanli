package com.bishe.ssm.dao;

import com.bishe.ssm.bean.CatExample;
import com.bishe.ssm.bean.Dog;
import com.bishe.ssm.bean.DogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DogMapper {
    long countByExample(DogExample example);

    int deleteByExample(DogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dog record);

    int insertSelective(Dog record);
    long countByExample();
    List<Dog> selectByExample(DogExample example);

    Dog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByExample(@Param("record") Dog record, @Param("example") DogExample example);

    int updateByPrimaryKeySelective(Dog record);

    int updateByPrimaryKey(Dog record);

    List<Dog> getAll();

    List<Dog> getByName(String dogname);
}
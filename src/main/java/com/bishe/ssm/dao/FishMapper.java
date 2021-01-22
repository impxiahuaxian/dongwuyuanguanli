package com.bishe.ssm.dao;

import com.bishe.ssm.bean.Fish;
import com.bishe.ssm.bean.FishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FishMapper {
    long countByExample(FishExample example);

    int deleteByExample(FishExample example);
    long countByExample();
    int deleteByPrimaryKey(Integer id);

    int insert(Fish record);

    int insertSelective(Fish record);

    List<Fish> selectByExample(FishExample example);

    Fish selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fish record, @Param("example") FishExample example);

    int updateByExample(@Param("record") Fish record, @Param("example") FishExample example);

    int updateByPrimaryKeySelective(Fish record);

    int updateByPrimaryKey(Fish record);

    List<Fish> getAll();

    List<Fish> getByName(String fishname);
}
package com.bishe.ssm.dao;

import com.bishe.ssm.bean.Mouse;
import com.bishe.ssm.bean.MouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseMapper {
    long countByExample(MouseExample example);

    int deleteByExample(MouseExample example);
    long countByExample();
    int deleteByPrimaryKey(Integer id);

    int insert(Mouse record);

    int insertSelective(Mouse record);

    List<Mouse> selectByExample(MouseExample example);

    Mouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mouse record, @Param("example") MouseExample example);

    int updateByExample(@Param("record") Mouse record, @Param("example") MouseExample example);

    int updateByPrimaryKeySelective(Mouse record);

    int updateByPrimaryKey(Mouse record);

    List<Mouse> getAll();

    List<Mouse> getByName(String mousename);
}
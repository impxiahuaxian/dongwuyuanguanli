package com.bishe.ssm.dao;

import com.bishe.ssm.bean.Ele;
import com.bishe.ssm.bean.EleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EleMapper {
    long countByExample(EleExample example);
    long countByExample();
    int deleteByExample(EleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ele record);

    int insertSelective(Ele record);

    List<Ele> selectByExample(EleExample example);

    Ele selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ele record, @Param("example") EleExample example);

    int updateByExample(@Param("record") Ele record, @Param("example") EleExample example);

    int updateByPrimaryKeySelective(Ele record);

    int updateByPrimaryKey(Ele record);

    List<Ele> getAll();

    List<Ele> getByName(String elename);
}
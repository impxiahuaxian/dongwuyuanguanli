package com.bishe.ssm.dao;


import com.bishe.ssm.bean.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageMapper {
    public List<Manage> getByName(String managename);
    public List<Manage> getAll();
    int insertManage(Manage manage);
    public List<Manage> getClasses();
    int updateByPrimaryKey(Manage manage);
    int deleteByPrimaryKey(String manageid);
    Manage getDataById(String manageid);
    String getPhotoAddr(String manageid);

}

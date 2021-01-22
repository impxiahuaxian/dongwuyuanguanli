package com.bishe.ssm.service;

import com.bishe.ssm.bean.Horse;
import com.bishe.ssm.bean.Manage;
import com.bishe.ssm.dao.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * 管理员Service层
 */
@Service
public class ManageService {

    @Autowired
    ManageMapper manageMapper;

    /**
     * 查询所有管理员信息
     * @param managename
     * @return
     */
    public  List<Manage> getAll(String managename){
        List<Manage> list = null;
        if(managename == null || "".equals(managename)){
            list = manageMapper.getAll();
        }else{
            managename = "%"+managename + "%";
            list = manageMapper.getByName(managename);
        }
        return list;
    }

    /**
     * 新增
     * @param manage
     */
    public void insertManage(Manage manage) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        manage.setManageid(uuid);
        manageMapper.insertManage(manage);

    }

    /**
     * 查询所有动物科类
     * @return
     */
    public List<Manage> getClasses() {
        List<Manage> list = manageMapper.getClasses();
        return list;
    }

    /**
     * 更新管理员信息
     * @param manage
     */
    public void updateManage(Manage manage) {
        manageMapper.updateByPrimaryKey(manage);
    }

    /**
     * 单个删除
     * @param manageid
     */
    public void deleteManage(String manageid) {
        manageMapper.deleteByPrimaryKey(manageid);
    }

    /**
     * 根据id查询用户详情
     * @param manageid
     * @return
     */
    public Manage getManage(String manageid) {
        Manage manage = manageMapper.getDataById(manageid);
        return manage;
    }

    /**
     * 根据manageid获取addr
     * @param manageid
     * @return
     */
    public String getPhotoAddr(String manageid) {
        String manage = manageMapper.getPhotoAddr(manageid);
        return manage;
    }

//    public int  insertPhotoAddr(String path, String manageid) {
//        Manage mange = new Manage();
//        mange.setManageid(manageid);
//        mange.setaddr(path);
//        int result = manageMapper.insertPhotoaAddr(mange);
//        return result;
//    }

    public String selectAddr(String manageid) {
        String manage = manageMapper.getPhotoAddr(manageid);
        return manage;
    }

}

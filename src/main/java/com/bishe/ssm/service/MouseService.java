package com.bishe.ssm.service;

import com.bishe.ssm.bean.*;
import com.bishe.ssm.dao.HorseMapper;
import com.bishe.ssm.dao.MouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 鼠类Service层
 */
@Service
public class MouseService {
    @Autowired
    MouseMapper mouseMapper;

    /**
     * 查询所有的马科动物信息
     * @param mousename
     * @return
     */
    public List<Mouse> getAll(String mousename){
        List<Mouse> list =null;
        if(mousename==null||"".equals(mousename)){
            list=mouseMapper.getAll();
        }else{
            mousename="%"+mousename+"%";
            list=mouseMapper.getByName(mousename);
        }
        return list;
    }

    /**
     * 新增
     * @param mouse
     */
    public void saveMouse(Mouse mouse) {
        mouseMapper.insertSelective(mouse);

    }


    /**
     * 校验名称
     * @param mouseName
     * @return
     */
    public boolean checkUser(String mouseName) {
        // TODO Auto-generated method stub
        MouseExample example = new MouseExample();
        MouseExample.Criteria criteria = example.createCriteria();
        criteria.andMousenameEqualTo(mouseName);
        long count = mouseMapper.countByExample(example);
        return count == 0;
    }


    /**
     * 根据id查询数据详情
     * @param id
     * @return
     */
    public Mouse getMouse(Integer id) {
        Mouse mouse = mouseMapper.selectByPrimaryKey(id);
        return mouse;
    }

    /**
     * 修改
     * @param mouse
     */
    public void updateMouse(Mouse mouse) {
        mouseMapper.updateByPrimaryKeySelective(mouse);
    }

    /**
     * 单个删除
     * @param id
     */
    public void deleteMouse(Integer id) {
        mouseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deletebatch(List<Integer> list) {
        for (int id : list) {
            deleteMouse(id);
        }
        return 1;
    }

}

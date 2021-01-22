package com.bishe.ssm.service;


import com.bishe.ssm.bean.Dog;
import com.bishe.ssm.bean.Ele;
import com.bishe.ssm.bean.EleExample;
import com.bishe.ssm.dao.EleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 脊索动物Service层
 */
@Service
public class EleService {
    @Autowired
    EleMapper eleMapper;

    /**
     * 查询所有脊索动物信息
     * @param elename
     * @return
     */
    public List<Ele> getAll(String elename){
        List<Ele> list =null;
        if(elename==null||"".equals(elename)){
            list=eleMapper.getAll();
        }else{
            elename="%"+elename+"%";
            list=eleMapper.getByName(elename);
        }
        return list;
    }
    //保存
    public void saveEle(Ele ele) {
        eleMapper.insertSelective(ele);

    }

    /**
     * 校验名称
     * @param eleName
     * @return
     */
    public boolean checkUser(String eleName) {
        EleExample example = new EleExample();
        EleExample.Criteria criteria = example.createCriteria();
        criteria.andElenameEqualTo(eleName);
        long count = eleMapper.countByExample(example);
        return count == 0;
    }


    /**
     * 根据id查询用户详情
     * @param id
     * @return
     */
    public Ele getEle(Integer id) {
        Ele ele = eleMapper.selectByPrimaryKey(id);
        return ele;
    }

    /**
     * 修改
     * @param ele
     */
    public void updateEle(Ele ele) {
        eleMapper.updateByPrimaryKeySelective(ele);
    }

    /**
     * 单个删除
     * @param id
     */
    public void deleteEle(Integer id) {
        eleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deletebatch(List<Integer> list) {
        for (int id : list) {
            deleteEle(id);
        }
        return 1;
    }

}

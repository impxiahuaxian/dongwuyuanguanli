package com.bishe.ssm.service;

import com.bishe.ssm.bean.Cat;
import com.bishe.ssm.bean.CatExample;
import com.bishe.ssm.dao.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 猫科Service层
 */
@Service
public class CatService {
    @Autowired
    CatMapper catMapper;

    /**
     * 查询所有马科动物信息
     * @param catname
     * @return
     */
    public List<Cat> getAll(String catname){
        List<Cat> list =null;
        if(catname==null||"".equals(catname)){
            list=catMapper.getAll();
        }else{
            catname="%"+catname+"%";
            list=catMapper.getByName(catname);
        }
        return list;
    }

    /**
     * 新增
     * @param cat
     */
    public void saveCat(Cat cat) {
        catMapper.insertSelective(cat);

    }


    /**
     * 校验名称
     * @param catName
     * @return
     */
    public boolean checkUser(String catName) {
        // TODO Auto-generated method stub
        CatExample example = new CatExample();
        CatExample.Criteria criteria = example.createCriteria();
        criteria.andCatnameEqualTo(catName);
        long count = catMapper.countByExample(example);
        return count == 0;
    }


    /**
     * 根据id查询数据详情
     * @param id
     * @return
     */
    public Cat getCat(Integer id) {
        Cat cat = catMapper.selectByPrimaryKey(id);
        return cat;
    }

    /**
     * 修改
     * @param cat
     */
    public void updateCat(Cat cat) {
        catMapper.updateByPrimaryKeySelective(cat);
    }

    /**
     * 单个删除
     * @param id
     */
    public void deleteCat(Integer id) {
        catMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deletebatch(List<Integer> list) {
        for (int id : list) {
            deleteCat(id);
        }
        return 1;
    }

}

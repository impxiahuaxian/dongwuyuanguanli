package com.bishe.ssm.service;

import com.bishe.ssm.bean.Ele;
import com.bishe.ssm.bean.Fish;
import com.bishe.ssm.bean.FishExample;
import com.bishe.ssm.dao.FishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 鱼类Service层
 */
@Service
public class FishService {
    @Autowired
    FishMapper fishMapper;

    /**
     * 查询所有鱼类动物信息
     * @param fishname
     * @return
     */
    public List<Fish> getAll(String fishname){
        List<Fish> list =null;
        if(fishname==null||"".equals(fishname)){
            list=fishMapper.getAll();
        }else{
            fishname="%"+fishname+"%";
            list=fishMapper.getByName(fishname);
        }
        return list;
    }

    /**
     * 新增
     * @param fish
     */
    public void saveFish(Fish fish) {
        fishMapper.insertSelective(fish);

    }

    /**
     * 名称校验
     * @param fishName
     * @return
     */
    public boolean checkUser(String fishName) {
        FishExample example = new FishExample();
        FishExample.Criteria criteria = example.createCriteria();
        criteria.andFishnameEqualTo(fishName);
        long count = fishMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 根据id查询数据详情
     * @param id
     * @return
     */
    public Fish getFish(Integer id) {
        Fish fish = fishMapper.selectByPrimaryKey(id);
        return fish;
    }

    /**
     * 修改
     * @param fish
     */
    public void updateFish(Fish fish) {
        fishMapper.updateByPrimaryKeySelective(fish);
    }

    /**
     * 单个删除
     * @param id
     */
    public void deleteFish(Integer id) {
        fishMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deletebatch(List<Integer> list) {
        for (int id : list) {
            deleteFish(id);
        }
        return 1;
    }
}

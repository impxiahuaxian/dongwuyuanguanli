package com.bishe.ssm.service;

import com.bishe.ssm.bean.Cat;
import com.bishe.ssm.bean.Dog;
import com.bishe.ssm.bean.DogExample;
import com.bishe.ssm.dao.DogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 犬科Service层
 */
@Service
public class DogService {

    @Autowired
    DogMapper dogMapper;

    /**
     * 查询所有犬科动物信息
     * @param dogname
     * @return
     */
    public List<Dog> getAll(String dogname){
        List<Dog> list =null;
        if(dogname==null||"".equals(dogname)){
            list=dogMapper.getAll();
        }else{
            dogname="%"+dogname+"%";
            list=dogMapper.getByName(dogname);
        }
        return list;
    }

    /**
     * 新增
     * @param dog
     */
    public void saveDog(Dog dog) {
        dogMapper.insertSelective(dog);

    }

    /**
     * 校验名称
     * @param dogName
     * @return
     */
    public boolean checkUser(String dogName) {
        DogExample example = new DogExample();
        DogExample.Criteria criteria = example.createCriteria();
        criteria.andDognameEqualTo(dogName);
        long count = dogMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 根据id查询数据详情
     * @param id
     * @return
     */
    public Dog getDog(Integer id) {
        Dog dog = dogMapper.selectByPrimaryKey(id);
        return dog;
    }

    /**
     * 修改
     * @param dog
     */
    public void updateDog(Dog dog) {
        dogMapper.updateByPrimaryKeySelective(dog);
    }

    /**
     * 单个删除
     * @param id
     */
    public void deleteDog(Integer id) {
        dogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deletebatch(List<Integer> list) {
        for (int id : list) {
            deleteDog(id);
        }
        return 1;
    }

    /**
     * 查询犬科动物数量
     * @return
     */
    public int allNumberDog() {
        int num= (int) dogMapper.countByExample();
        return num;
    }
}

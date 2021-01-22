package com.bishe.ssm.service;

import com.bishe.ssm.bean.Horse;
import com.bishe.ssm.bean.HorseExample;
import com.bishe.ssm.bean.Manage;
import com.bishe.ssm.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * 马科Service层
 */
@Service
public class HorseService {

	@Autowired
    HorseMapper horseMapper;

	@Autowired
	FishMapper fishMapper;

	@Autowired
	MouseMapper mouseMapper;

	@Autowired
	EleMapper eleMapper;

	@Autowired
	CatMapper catMapper;

	/**
	 * 查询所有马科动物信息
	 * @param horsename
	 * @return
	 */
	public List<Horse> getAll(String horsename){
	    //List<Horse> list = horseMapper.selectByExample(null);
		List<Horse> list = null;
		if(horsename == null || "".equals(horsename)){
			list = horseMapper.getAll();
		}else{
			horsename = "%"+horsename + "%";
			list = horseMapper.getByName(horsename);
		}
	    return list;
    }


	/**
	 * 新增
	 * @param horse
	 */
	public void saveHorse(Horse horse) {
		 horseMapper.insertSelective(horse);

	}

	/**
	 * 校验名称
	 * @param horseName
	 * @return+
	 */
	public boolean checkUser(String horseName) {
		HorseExample example = new HorseExample();
		HorseExample.Criteria criteria = example.createCriteria();
		criteria.andHorsenameEqualTo(horseName);
		long count = horseMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 根据id查询数据详情
	 * @param id
	 * @return
	 */
	public Horse getHorse(Integer id) {
		Horse horse = horseMapper.selectByPrimaryKey(id);
		return horse;
	}

	/**
	 * 修改
	 * @param horse
	 */
	public void updateHorse(Horse horse) {
		horseMapper.updateByPrimaryKeySelective(horse);
	}

	/**
	 * 单个删除
	 * @param id
	 */
	public void deleteHorse(Integer id) {
		horseMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 * @param list
	 * @return
	 */
	public int deletebatch(List<Integer> list) {
		for (int id : list) {
			deleteHorse(id);
		}
		return 1;
	}


	/**
	 * 查询马科动物数量
	 * @return
	 */
	public int allNumberHorse() {
		int num= (int) horseMapper.countByExample();
		return num;
	}

	/**
	 * 查询鱼类动物数量
	 * @return
	 */
	public int allNumberFish() {
		int num= (int) fishMapper.countByExample();
		return num;
	}

	/**
	 * 查询鼠类动物数量
	 * @return
	 */
	public int allNumberMouse() {
		int num= (int) mouseMapper.countByExample();
		return num;
	}

	/**
	 * 查询脊索动物数量
	 * @return
	 */
	public int allNumberEle() {
		int num= (int) eleMapper.countByExample();
		return num;
	}

	/**
	 * 查询猫科动物数量
	 * @return
	 */
	public int allNumberCat() {
		int num= (int) catMapper.countByExample();
		return num;
	}

	public List<Manage> getManage(){
		Manage manage= (Manage) horseMapper.getManage();
		return (List<Manage>) manage;
	}
}

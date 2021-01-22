package com.bishe.ssm.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 测试dao层的操作
 * ContextConfiguration自动创建 spring ioc容器
 * RunWith 是Junit的注解
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

//	@Autowired
//	HorseMapper horseMapper;
//	@Autowired
//	CatMapper catMapper;
//	//在配置文件里配置了一个可以批量删除的Sqlsession
//	@Autowired
//	SqlSession sqlSession;
//		@Test
//		public void testCRUD(){
//		/*	//1、创建SpringIOC容器
//			ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//			//2、从容器中获取mapper
//			DepartmentMapper bean = ioc.getBean(HorseMapper.class);*/
//			System.out.println(horseMapper);
//			System.out.println(catMapper);
////			horseMapper.insertSelective(new Horse(null,"公","懒洋洋马",8,"青青草原",null,"爱吃萝卜青菜"));
////			catMapper.insertSelective(new Cat(null,"公","小花猫",2,"美国",null,"绿色和红色相间"));
//			//批量插入
//			HorseMapper mapper=sqlSession.getMapper(HorseMapper.class);
//			for(int i = 0;i<15;i++){
//				String uid = UUID.randomUUID().toString().substring(0,5)+i;
//				int ages = (int) (Math.random()*10+2);
//				mapper.insertSelective(new Horse(null,"公",uid,ages,"伟大中国"+uid,null,"傲然挺立，窥探世界"));
//			}
//			System.out.println("批量完成");
//		}

	}


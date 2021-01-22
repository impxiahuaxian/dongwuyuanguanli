package com.bishe.ssm.test;

import java.util.List;

import com.bishe.ssm.bean.Horse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;


/*
 * 使用spring测试模块提供的测试请求功能，测试crud的正确性
 * spring4测试的时候，需要3.0的servletjar包的支持的支持
 * */

@RunWith(SpringJUnit4ClassRunner.class)
//获取WebIOC容器
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:D:\\soft\\bishe-ssm3\\src\\main\\webapp\\WEB-INF\\dispatcherServlet-servlet.xml"})
public class MvcTest {
    // 传入Springmvc的ioc
    @Autowired
    WebApplicationContext context;
    // 虚拟mvc请求，获取到处理结果。
    MockMvc mockMvc;

    //初始化mocMvc
    @Before
    public void initMokcMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/horses").param("pn", "4"))
                .andReturn();

        //请求成功以后，请求域中会有pageInfo；我们可以取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码："+pi.getPageNum());
        System.out.println("总页码："+pi.getPages());
        System.out.println("总记录数："+pi.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] nums = pi.getNavigatepageNums();
        for (int i : nums) {
            System.out.print(" "+i);
        }

        //获取员工数据
        List<Horse> list = pi.getList();
        for (Horse horse : list) {
            System.out.println("ID："+horse.getId()+"==>Name:"+horse.getHorsename());
        }



    }
}

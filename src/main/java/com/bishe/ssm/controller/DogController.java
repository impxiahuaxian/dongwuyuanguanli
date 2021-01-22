package com.bishe.ssm.controller;


import com.bishe.ssm.bean.Dog;
import com.bishe.ssm.bean.Msg;
import com.bishe.ssm.service.DogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 犬科控制器
 */
@Controller
public class DogController {
    @Autowired
    DogService dogService;

    /**
     * 分页查询
     * @param pn
     * @param model
     * @param dogname
     * @return
     */
    @RequestMapping("/dogs")
    public String getDogs(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,String dogname){
        //引入分页（传入页码 ，每页显示条数）
        PageHelper.startPage(pn,6);
        List<Dog> dogs= dogService.getAll(dogname);
        //将查询结果封装到pageinfo中,只需将PageInfo交给页面即可。（PageInfo中包括分页信息，以及查询出来的所有马科动物信息）每页连续显示几页
        PageInfo page=new PageInfo(dogs,4);
        //通过Model将PageInfo交给页面
        model.addAttribute("pageInfo",page);
        return "dogList";
    }

    /**
     * 新增
     * @param dog
     * @return
     */
    @RequestMapping(value="/dog")
    @ResponseBody
    public Msg saveEmp(Dog dog){
        dogService.saveDog(dog);
        return Msg.success();
    }

    /**
     * 校验名称
     * @param dogName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuserDog")
    public Msg checkuser(@RequestParam("dogName")String dogName) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        Msg msgModel = new Msg();
        if (!dogName.matches(regx)) {
            msgModel = Msg.fail();
            msgModel.setMsg("名称必须是6-16位数字和字母的组合或者2-5位中文");
            return msgModel;
        }
        //数据库用户名重复校验
        boolean b = dogService.checkUser(dogName);
        if (b) {
            return Msg.success();
        } else {
            msgModel = Msg.fail();
            msgModel.setMsg("名称重复");
            return msgModel;
        }
    }

    /**
     * 根据id查询数据详情
     * @param id
     * @return
     */
    @RequestMapping(value="/dog/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getDog(@PathVariable("id")Integer id){

        Dog dog = dogService.getDog(id);
        return Msg.success().add("dog", dog);
    }

    /**
     * 修改
     * @param dog
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/dog/{id}",method=RequestMethod.PUT)
    public Msg saveEmp(Dog dog, HttpServletRequest request){
        System.out.println("将要更新的员工数据"+dog);
        dogService.updateDog(dog);
        return Msg.success()	;
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/dog1/{id}",method=RequestMethod.DELETE)
    public Msg deleteDog(@PathVariable("id")Integer id){
        dogService.deleteDog(id);
        return Msg.success()	;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/dogDeleteBatch")
    public Msg deletebatch(String ids) {
        //dogService.deletebatch(ids);
        String idsStr = ids.substring(0, ids.length() - 1);
        String[] idsArrys = idsStr.split(",");
        List<Integer> idsInt = new ArrayList<Integer>();
        for (int i = 0; i < idsArrys.length; i++) {
            Integer id = Integer.parseInt(idsArrys[i]);
            idsInt.add(id);
        }
        dogService.deletebatch(idsInt);
        return Msg.success();
    }

}

package com.bishe.ssm.controller;

import com.bishe.ssm.bean.Cat;
import com.bishe.ssm.bean.Msg;

import com.bishe.ssm.service.CatService;
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
 * 猫科控制器
 */
@Controller
public class CatController {
    @Autowired
    CatService catService;

    /**
     *分页查询
     * @param pn
     * @param model
     * @param catname
     * @return
     */
    @RequestMapping("/cats")
    public String getCats(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,String catname){
        //引入分页（传入页码 ，每页显示条数）
        PageHelper.startPage(pn,6);
        List<Cat> cats= catService.getAll(catname);
        //将查询结果封装到pageinfo中,只需将PageInfo交给页面即可。（PageInfo中包括分页信息，以及查询出来的所有马科动物信息）每页连续显示几页
        PageInfo page=new PageInfo(cats,4);
        //通过Model将PageInfo交给页面
        model.addAttribute("pageInfo",page);
        return "catList";
    }

    /**
     *新增
     * @param cat
     * @return
     */
    @RequestMapping(value="/cat")
    @ResponseBody
    public Msg saveEmp(Cat cat){
        catService.saveCat(cat);
        return Msg.success();
    }

    /**
     *校验名称
     * @param catName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuserCat")
    public Msg checkuser(@RequestParam("catName")String catName) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        Msg msgModel = new Msg();
        if (!catName.matches(regx)) {
            //return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
            msgModel = Msg.fail();
            msgModel.setMsg("名称必须是6-16位数字和字母的组合或者2-5位中文");
            return msgModel;
        }
        //数据库用户名重复校验
        boolean b = catService.checkUser(catName);
        if (b) {
            return Msg.success();
        } else {
            msgModel = Msg.fail();
            msgModel.setMsg("用户名重复");
            return msgModel;
        }
    }

    /**
     *根据id查询数据详情
     * @param id
     * @return
     */
    @RequestMapping(value="/cat/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getCat(@PathVariable("id")Integer id){

        Cat cat = catService.getCat(id);
        return Msg.success().add("cat", cat);
    }

    /**
     *修改
     * @param cat
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/cat2/{id}",method=RequestMethod.PUT)
    public Msg saveEmp(Cat cat, HttpServletRequest request){
        catService.updateCat(cat);
        return Msg.success();
    }

    /**
     *单个删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cat1/{id}",method=RequestMethod.DELETE)
    public Msg deleteCat(@PathVariable("id")Integer id){
        catService.deleteCat(id);
        return Msg.success();
    }

    /**
     *批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/catDeleteBatch")
    public Msg deletebatch(String ids) {
        //剪切掉ids字符串最后面的逗号
        String idsStr = ids.substring(0, ids.length() - 1);
        String[] idsArrys = idsStr.split(",");
        List<Integer> idsInt = new ArrayList<Integer>();
        for (int i = 0; i < idsArrys.length; i++) {
            Integer id = Integer.parseInt(idsArrys[i]);
            idsInt.add(id);
        }
        catService.deletebatch(idsInt);
        return Msg.success();
    }

}

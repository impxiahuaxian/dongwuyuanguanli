package com.bishe.ssm.controller;

import com.bishe.ssm.bean.Ele;
import com.bishe.ssm.bean.Horse;
import com.bishe.ssm.bean.Msg;
import com.bishe.ssm.service.EleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 脊索动物控制器
 */
@Controller
public class EleController {

    @Autowired
    EleService eleService;

    /**
     * 分页查询
     * @param pn
     * @param model
     * @param elename
     * @return
     */
    @RequestMapping("/eles")
    public String getEles(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,String elename){
        //引入分页（传入页码 ，每页显示条数）
        PageHelper.startPage(pn,6);
        List<Ele> eles= eleService.getAll(elename);
        //将查询结果封装到pageinfo中,只需将PageInfo交给页面即可。（PageInfo中包括分页信息，以及查询出来的所有马科动物信息）每页连续显示几页
        PageInfo page=new PageInfo(eles,4);
        //通过Model将PageInfo交给页面
        model.addAttribute("pageInfo",page);
        return "eleList";
    }

    /**
     * 新增
     * @param ele
     * @return
     */
    @RequestMapping(value = "/ele")
    @ResponseBody
    public Msg saveEle(Ele ele) {
        eleService.saveEle(ele);
        return Msg.success();
    }

    /**
     * 校验名称
     * @param eleName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuserEle")
    public Msg checkuser(@RequestParam("eleName")String eleName) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        Msg msgModel = new Msg();
        if (!eleName.matches(regx)) {
            //return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
            msgModel = Msg.fail();
            msgModel.setMsg("名称必须是6-16位数字和字母的组合或者2-5位中文");
            return msgModel;
        }
        //数据库用户名重复校验
        boolean b = eleService.checkUser(eleName);
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
    @RequestMapping(value="/ele/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getEle(@PathVariable("id")Integer id){

        Ele ele = eleService.getEle(id);
        return Msg.success().add("ele", ele);
    }

    /**
     * 修改
     * @param ele
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/ele2/{id}",method=RequestMethod.PUT)
    public Msg saveEmp(Ele ele, HttpServletRequest request){
        System.out.println("将要更新的员工数据"+ele);
        eleService.updateEle(ele);
        return Msg.success()	;
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ele1/{id}",method=RequestMethod.DELETE)
    public Msg deleteEle(@PathVariable("id")Integer id){
        eleService.deleteEle(id);
        return Msg.success()	;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/eleDeleteBatch")
    public Msg deletebatch(String ids) {
        //eleService.deletebatch(ids);
        String idsStr = ids.substring(0, ids.length() - 1);
        String[] idsArrys = idsStr.split(",");
        List<Integer> idsInt = new ArrayList<Integer>();
        for (int i = 0; i < idsArrys.length; i++) {
            Integer id = Integer.parseInt(idsArrys[i]);
            idsInt.add(id);
        }
        eleService.deletebatch(idsInt);
        return Msg.success();
    }
}

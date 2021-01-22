package com.bishe.ssm.controller;

import com.bishe.ssm.bean.Mouse;
import com.bishe.ssm.bean.Msg;
import com.bishe.ssm.service.MouseService;
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
 * 鼠类选择器
 */
@Controller
public class MouseController {

    @Autowired
    MouseService mouseService;

    /**
     * 分页查询
     * @param pn
     * @param model
     * @param mousename
     * @return
     */
    @RequestMapping("/mouses")
    public String getMouses(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,String mousename){
        //引入分页（传入页码 ，每页显示条数）
        PageHelper.startPage(pn,6);
        List<Mouse> mouses= mouseService.getAll(mousename);
        //将查询结果封装到pageinfo中,只需将PageInfo交给页面即可。（PageInfo中包括分页信息，以及查询出来的所有马科动物信息）每页连续显示几页
        PageInfo page=new PageInfo(mouses,4);
        //通过Model将PageInfo交给页面
        model.addAttribute("pageInfo",page);
        return "MouseList";
    }

    /**
     * 新增
     * @param mouse
     * @return
     */
    @RequestMapping(value="/mouse")
    @ResponseBody
    public Msg saveMouse(Mouse mouse){
        mouseService.saveMouse(mouse);
        return Msg.success();
    }

    /**
     * 校验名称
     * @param mouseName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuserMouse")
    public Msg checkuser(@RequestParam("mouseName")String mouseName) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        Msg msgModel = new Msg();
        if (!mouseName.matches(regx)) {
            msgModel = Msg.fail();
            msgModel.setMsg("名称必须是6-16位数字和字母的组合或者2-5位中文");
            return msgModel;
        }
        //数据库名称重复校验
        boolean b = mouseService.checkUser(mouseName);
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
    @RequestMapping(value="/mouse/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getMouse(@PathVariable("id")Integer id){

        Mouse mouse = mouseService.getMouse(id);
        return Msg.success().add("mouse", mouse);
    }

    /**
     * 修改
     * @param mouse
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/mouse2/{id}",method=RequestMethod.PUT)
    public Msg saveMouse(Mouse mouse, HttpServletRequest request){
        System.out.println("将要修改的动物数据"+mouse);
        mouseService.updateMouse(mouse);
        return Msg.success()	;
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/mouse1/{id}",method=RequestMethod.DELETE)
    public Msg deleteMouse(@PathVariable("id")Integer id){
        mouseService.deleteMouse(id);
        return Msg.success()	;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/mouseDeleteBatch")
    public Msg deletebatch(String ids) {
        //mouseService.deletebatch(ids);
        String idsStr = ids.substring(0, ids.length() - 1);
        String[] idsArrys = idsStr.split(",");
        List<Integer> idsInt = new ArrayList<Integer>();
        for (int i = 0; i < idsArrys.length; i++) {
            Integer id = Integer.parseInt(idsArrys[i]);
            idsInt.add(id);
        }
        mouseService.deletebatch(idsInt);
        return Msg.success();
    }

}

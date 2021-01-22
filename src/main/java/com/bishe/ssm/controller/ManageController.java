package com.bishe.ssm.controller;

import com.bishe.ssm.bean.Horse;
import com.bishe.ssm.bean.Manage;
import com.bishe.ssm.bean.Msg;
import com.bishe.ssm.service.ManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * 管理员控制器
 */
@Controller
public class ManageController {
    @Autowired
    ManageService manageService;

    /**
     * 分页查询
     * @param pn
     * @param model
     * @param managename
     * @return
     */
    @RequestMapping("/manages")
    public String getHorses(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model, String managename){
        /* 引入分页（传入页码 ，每页显示条数） */
        PageHelper.startPage(pn,6);
        List<Manage> manages= manageService.getAll(managename);
        //将查询结果封装到pageinfo中,只需将PageInfo交给页面即可。（PageInfo中包括分页信息，以及查询出来的所有马科动物信息）每页连续显示几页
        PageInfo page=new PageInfo(manages,4);
        //通过Model将PageInfo交给页面
        model.addAttribute("pageInfo",page);
        return "manage";
    }

    /**
     * 新增
     * @param manage
     * @return
     */
    @RequestMapping(value="/manage",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveManage(@RequestParam(value = "img") String base64Str,Manage manage,String fileType) throws IOException {
        //防止文件名重复，使用UUID作为文件名
        String path = "D:\\imgs\\"+ UUID.randomUUID().toString() + "." + fileType;
        //解码
        Files.write(Paths.get(path), Base64.getDecoder().decode(base64Str), StandardOpenOption.CREATE);
        manage.setaddr(path);
        manageService.insertManage(manage);
        return Msg.success();
    }

    /**
     * 返回所有的动物科类信息
     */
    @RequestMapping("/classes")
    @ResponseBody
    public Msg getClasses(){
        List<Manage> list = manageService.getClasses();
        return Msg.success().add("classes", list);
    }

    /**
     *
     * 修改
     * @param manage
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/manage2/{manageid}",method=RequestMethod.PUT)
    public Msg saveEmp(@RequestParam(value = "img") String base64Str,Manage manage,String fileType) throws IOException {
        //防止文件名重复，使用UUID作为文件名
        String path = "D:\\imgs\\"+ UUID.randomUUID().toString() + "." + fileType;
        //解码
        Files.write(Paths.get(path), Base64.getDecoder().decode(base64Str), StandardOpenOption.CREATE);
        manage.setaddr(path);
        manageService.updateManage(manage);
        return Msg.success();
    }

    /**
     * 删除
     * @param manageid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manage1/{manageid}",method=RequestMethod.DELETE)
    public Msg deleteManage(@PathVariable("manageid")String manageid){
        manageService.deleteManage(manageid);
        return Msg.success()	;
    }

    /**
     * 根据id查询数据详情
     * @param manageid
     * @return
     */
    @RequestMapping(value="/manageByid/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getManage(@PathVariable("id")String manageid){
        Manage manage = manageService.getManage(manageid);
        return Msg.success().add("manage", manage);
    }

}

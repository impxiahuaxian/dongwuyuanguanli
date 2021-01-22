package com.bishe.ssm.controller;

import com.bishe.ssm.bean.Horse;
import com.bishe.ssm.bean.Msg;
import com.bishe.ssm.service.HorseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 马科控制器
 */
@Controller
public class HorseController {

    @Autowired
    HorseService horseService;

    /**
     * 分页查询
     * @param pn
     * @param model
     * @param horsename
     * @return
     */
    //RequestParam表示接收前台传过来的value = "pn"参数将其命名为Integer pn，默认值为1
    @RequestMapping("/horses")
    public String getHorses(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model, String horsename) {
        //引入分页（传入页码 ，每页显示条数）
        PageHelper.startPage(pn, 6);
        List<Horse> horses = horseService.getAll(horsename);
        //将查询结果封装到pageinfo中,只需将PageInfo交给页面即可。（PageInfo中包括分页信息，以及查询出来的所有马科动物信息）每页连续显示几页
        PageInfo page = new PageInfo(horses, 4);
        //通过Model将PageInfo交给前台页面
        model.addAttribute("pageInfo", page);
        return "list";
    }

    /**
     * 新增
     * @param horse
     * @return
     */
    @RequestMapping(value = "/horse")
    @ResponseBody
    public Msg saveEmp(Horse horse) {
        horseService.saveHorse(horse);
        return Msg.success();
    }

    /**
     * 校验名称
     * @param horseName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkuser")
    public Msg checkuser(@RequestParam("horseName") String horseName) {
        //先判断用户名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        Msg msgModel = new Msg();
        if (!horseName.matches(regx)) {
            msgModel = Msg.fail();
            msgModel.setMsg("用户名必须是6-16位数字和字母的组合或者2-5位中文");
            return msgModel;
        }
        //数据库用户名重复校验
        boolean b = horseService.checkUser(horseName);
        if (b) {
            return Msg.success();
        } else {
            msgModel = Msg.fail();
            msgModel.setMsg("用户名重复");
            return msgModel;
        }
    }

    /**
     * 根据id查询数据详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/horse/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getHorse(@PathVariable("id") Integer id) {

        Horse horse = horseService.getHorse(id);
        return Msg.success().add("horse", horse);
    }

    /**
     * 修改
     * @param horse
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/horse2/{id}", method = RequestMethod.PUT)
    public Msg saveEmp(Horse horse, HttpServletRequest request) {
        horseService.updateHorse(horse);
        return Msg.success();
    }

    /**
     * 删除单个动物信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/horse1/{id}", method = RequestMethod.DELETE)
    public Msg deleteHorse(@PathVariable("id") Integer id) {
        horseService.deleteHorse(id);
        return Msg.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/horseDeleteBatch")
    public Msg deletebatch(String ids) {
        //horseService.deletebatch(ids);
        String idsStr = ids.substring(0, ids.length() - 1);
        String[] idsArrys = idsStr.split(",");
        List<Integer> idsInt = new ArrayList<Integer>();
        for (int i = 0; i < idsArrys.length; i++) {
            Integer id = Integer.parseInt(idsArrys[i]);
            idsInt.add(id);
        }
        horseService.deletebatch(idsInt);
        return Msg.success();
    }

    /**
     * 获取各科动物数量及名字
     * @return
     */
    @ResponseBody
    @RequestMapping("/numAndName")
    public Map<String, Object> getDetailByID() {
        List list = new ArrayList();
        List list1 = new ArrayList();
        int num1 = horseService.allNumberHorse();
        int num2 = horseService.allNumberCat();
        int num3 = horseService.allNumberEle();
        int num4 = horseService.allNumberFish();
        int num5 = horseService.allNumberMouse();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        list.add(num5);
        String[] arrs = new String[]{"马科", "猫科", "脊索动物", "鱼类", "鼠类"};
        for (String i : arrs) {
            list1.add(i);
        }
        Map<String, Object> finalMap = new HashMap<String, Object>();
        finalMap.put("name", list1);
        finalMap.put("count", list);
        return finalMap;
    }

}


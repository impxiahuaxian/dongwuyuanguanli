package com.bishe.ssm.bean;


import java.util.HashMap;
import java.util.Map;

/*
 * 通用的返回类，用于返回json数据
 * */
public class Msg {

    //状态码   100-成功    200-失败
    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    //用户要返回给浏览器的数据
    private Map<String,Object> extend=new HashMap<String,Object>();

    //状态码 100-成功  200-失败
    private int code;
    //提示信息
    private String msg;
    //请求成功,返回状态码100，并显示提示信息
    public static Msg success(){
        Msg result=new Msg();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }
    //请求失败时
    //请求失败,返回状态码200，并显示提示信息
    public static Msg fail(){
        Msg result=new Msg();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }
    //用户要返回给浏览器的数据
    public Msg add(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }
}

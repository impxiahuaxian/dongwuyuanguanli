package com.bishe.ssm.bean;

import java.util.Date;

public class Mouse {
    private Integer id;

    private String sex;

    private String mousename;

    private Integer age;

    private String comefrom;

    private String tozootime;

    private String mousedescribe;

    private String classes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getMousename() {
        return mousename;
    }

    public void setMousename(String mousename) {
        this.mousename = mousename == null ? null : mousename.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom == null ? null : comefrom.trim();
    }

    public String getTozootime() {
        return tozootime;
    }

    public void setTozootime(String tozootime) {
        this.tozootime = tozootime;
    }

    public String getMousedescribe() {
        return mousedescribe;
    }

    public void setMousedescribe(String mousedescribe) {
        this.mousedescribe = mousedescribe == null ? null : mousedescribe.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Mouse() {
    }

    public Mouse(Integer id, String sex, String mousename, Integer age, String comefrom, String tozootime, String mousedescribe, String classes) {
        this.id = id;
        this.sex = sex;
        this.mousename = mousename;
        this.age = age;
        this.comefrom = comefrom;
        this.tozootime = tozootime;
        this.mousedescribe = mousedescribe;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", mousename='" + mousename + '\'' +
                ", age=" + age +
                ", comefrom='" + comefrom + '\'' +
                ", tozootime='" + tozootime + '\'' +
                ", mousedescribe='" + mousedescribe + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
package com.bishe.ssm.bean;

import java.util.Date;

public class Ele {
    private Integer id;

    private String sex;

    private String elename;

    private Integer age;

    private String comefrom;

    private String tozootime;

    private String eledescribe;

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
        this.sex = sex;
    }

    public String getElename() {
        return elename;
    }

    public void setElename(String elename) {
        this.elename = elename;
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
        this.comefrom = comefrom;
    }

    public String getTozootime() {
        return tozootime;
    }

    public void setTozootime(String tozootime) {
        this.tozootime = tozootime;
    }

    public String getEledescribe() {
        return eledescribe;
    }

    public void setEledescribe(String eledescribe) {
        this.eledescribe = eledescribe;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Ele() {
    }

    public Ele(Integer id, String sex, String elename, Integer age, String comefrom, String tozootime, String eledescribe, String classes) {
        this.id = id;
        this.sex = sex;
        this.elename = elename;
        this.age = age;
        this.comefrom = comefrom;
        this.tozootime = tozootime;
        this.eledescribe = eledescribe;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Ele{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", elename='" + elename + '\'' +
                ", age=" + age +
                ", comefrom='" + comefrom + '\'' +
                ", tozootime='" + tozootime + '\'' +
                ", eledescribe='" + eledescribe + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
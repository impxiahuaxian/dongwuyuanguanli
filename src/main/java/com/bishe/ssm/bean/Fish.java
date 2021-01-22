package com.bishe.ssm.bean;

import java.util.Date;

public class Fish {
    private Integer id;

    private String sex;

    private String fishname;

    private Integer age;

    private String comefrom;

    private String tozootime;

    private String fishdescribe;

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

    public String getFishname() {
        return fishname;
    }

    public void setFishname(String fishname) {
        this.fishname = fishname == null ? null : fishname.trim();
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

    public String getFishdescribe() {
        return fishdescribe;
    }

    public void setFishdescribe(String fishdescribe) {
        this.fishdescribe = fishdescribe == null ? null : fishdescribe.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Fish() {
    }

    public Fish(Integer id, String sex, String fishname, Integer age, String comefrom, String tozootime, String fishdescribe, String classes) {
        this.id = id;
        this.sex = sex;
        this.fishname = fishname;
        this.age = age;
        this.comefrom = comefrom;
        this.tozootime = tozootime;
        this.fishdescribe = fishdescribe;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", fishname='" + fishname + '\'' +
                ", age=" + age +
                ", comefrom='" + comefrom + '\'' +
                ", tozootime='" + tozootime + '\'' +
                ", fishdescribe='" + fishdescribe + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
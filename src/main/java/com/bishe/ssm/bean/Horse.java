package com.bishe.ssm.bean;

import java.util.Date;

public class Horse {
    private Integer id;

    private String sex;

    private String horsename;

    private Integer age;

    private String comefrom;

    private String tozootime;

    private String horsedescribe;

    private String classes;

    public Horse() {
    }

    public Horse(Integer id, String sex, String horsename, Integer age, String comefrom, String tozootime, String horsedescribe,String classes) {
        this.id = id;
        this.sex = sex;
        this.horsename = horsename;
        this.age = age;
        this.comefrom = comefrom;
        this.tozootime = tozootime;
        this.horsedescribe = horsedescribe;
        this.classes = classes;
    }

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

    public String getHorsename() {
        return horsename;
    }

    public void setHorsename(String horsename) {
        this.horsename = horsename;
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getHorsedescribe() {
        return horsedescribe;
    }

    public void setHorsedescribe(String horsedescribe) {
        this.horsedescribe = horsedescribe;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", horsename='" + horsename + '\'' +
                ", age=" + age +
                ", comefrom='" + comefrom + '\'' +
                ", tozootime='" + tozootime + '\'' +
                ", horsedescribe='" + horsedescribe + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
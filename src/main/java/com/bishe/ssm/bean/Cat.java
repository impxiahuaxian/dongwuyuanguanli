package com.bishe.ssm.bean;

public class Cat {
    private Integer id;

    private String sex;

    private String catname;

    private Integer age;

    private String comefrom;

    private String tozootime;

    private String catdescribe;

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

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname == null ? null : catname.trim();
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

    public String getCatdescribe() {
        return catdescribe;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setCatdescribe(String catdescribe) {
        this.catdescribe = catdescribe == null ? null : catdescribe.trim();
    }
}
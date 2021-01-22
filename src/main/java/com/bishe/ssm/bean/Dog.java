package com.bishe.ssm.bean;


public class Dog {
    private Integer id;

    private String sex;

    private String dogname;

    private Integer age;

    private String comefrom;

    private String tozootime;

    private String dogdescribe;

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

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname == null ? null : dogname.trim();
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

    public String getDogdescribe() {
        return dogdescribe;
    }

    public void setDogdescribe(String dogdescribe) {
        this.dogdescribe = dogdescribe == null ? null : dogdescribe.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Dog() {
    }

    public Dog(Integer id, String sex, String dogname, Integer age, String comefrom, String tozootime, String dogdescribe, String classes) {
        this.id = id;
        this.sex = sex;
        this.dogname = dogname;
        this.age = age;
        this.comefrom = comefrom;
        this.tozootime = tozootime;
        this.dogdescribe = dogdescribe;
        this.classes = classes;
    }
}
package com.bishe.ssm.bean;

public class Manage {
    String manageid;
    String managename;
    String sex;
    String classes;
    String  phone;
    String addr;
    public Manage() {
    }

    public Manage(String manageid, String managename, String sex, String classes, String phone, String addr) {
        this.manageid = manageid;
        this.managename = managename;
        this.sex = sex;
        this.classes = classes;
        this.phone = phone;
        this.addr = addr;
    }

    public String getManageid() {
        return manageid;
    }

    public void setManageid(String manageid) {
        this.manageid = manageid;
    }

    public String getManagename() {
        return managename;
    }

    public void setManagename(String managename) {
        this.managename = managename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getaddr() {
        return addr;
    }

    public void setaddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Manege{" +
                "manageid='" + manageid + '\'' +
                ", managename='" + managename + '\'' +
                ", sex='" + sex + '\'' +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}

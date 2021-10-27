package com.zyp.dbe.pojo;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 9:45
 * @PackageName: com.zyp.dbe.pojo
 */

public class Student {
    String name;
    int id;
    String sex;
    int age;
    String tel;
    String addr;
    String major;

    public Student() {
    }

    public Student(String name, int id, String sex, int age, String tel, String addr, String major) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.addr = addr;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getTel() {
        return tel;
    }

    public String getAddr() {
        return addr;
    }

    public String getMajor() {
        return major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

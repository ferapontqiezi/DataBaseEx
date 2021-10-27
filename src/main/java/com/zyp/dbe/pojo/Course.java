package com.zyp.dbe.pojo;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 18:53
 * @PackageName: com.zyp.dbe.pojo
 */

public class Course {
    String name;
    int id;
    double credit;

    public Course() {
    }

    public Course(String name, int id, double credit) {
        this.name = name;
        this.id = id;
        this.credit = credit;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", credit=" + credit +
                '}';
    }
}

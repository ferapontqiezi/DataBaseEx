package com.zyp.dbe.pojo;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 18:53
 * @PackageName: com.zyp.dbe.pojo
 */

public class Course {
    String Cno;
    String Cname;
    String Cpno;
    short Ccredit;

    public Course() {
    }

    public Course(String cno, String cname, String cpno, short ccredit) {
        Cno = cno;
        Cname = cname;
        Cpno = cpno;
        Ccredit = ccredit;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCpno() {
        return Cpno;
    }

    public void setCpno(String cpno) {
        Cpno = cpno;
    }

    public short getCcredit() {
        return Ccredit;
    }

    public void setCcredit(short ccredit) {
        Ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Cno='" + Cno + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Cpno='" + Cpno + '\'' +
                ", Ccredit=" + Ccredit +
                '}';
    }
}

package com.zyp.dbe.pojo;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 9:45
 * @PackageName: com.zyp.dbe.pojo
 */

public class Student {
    String Sno;
    String Sname;
    String Ssex;
    short Sage;
    String Sdept;
    String Sscholarship;

    public Student() {
    }

    public Student(String sno, String sname, String ssex, short sage, String sdept, String sscholarship) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Sdept = sdept;
        Sscholarship = sscholarship;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public short getSage() {
        return Sage;
    }

    public void setSage(short sage) {
        Sage = sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    public String getSscholarship() {
        return Sscholarship;
    }

    public void setSscholarship(String sscholarship) {
        Sscholarship = sscholarship;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno='" + Sno + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sage=" + Sage +
                ", Sdept='" + Sdept + '\'' +
                ", Sscholarship='" + Sscholarship + '\'' +
                '}';
    }
}

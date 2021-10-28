package com.zyp.dbe.pojo;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 19:26
 * @PackageID: com.zyp.dbe.pojo
 */

public class Grades {
    String Sno;
    String Cno;
    short Grade;

    public Grades() {
    }

    public Grades(String sno, String cno, short grade) {
        Sno = sno;
        Cno = cno;
        Grade = grade;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public short getGrade() {
        return Grade;
    }

    public void setGrade(short grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "Sno='" + Sno + '\'' +
                ", Cno='" + Cno + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}

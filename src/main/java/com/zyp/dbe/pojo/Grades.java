package com.zyp.dbe.pojo;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 19:26
 * @PackageID: com.zyp.dbe.pojo
 */

public class Grades {
    int studentID;
    int courseID;
    int grade;

    public Grades() {
    }

    public Grades(int studentID, int courseID, int grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "studentID='" + studentID + '\'' +
                ", courseID='" + courseID + '\'' +
                ", grade=" + grade +
                '}';
    }
}

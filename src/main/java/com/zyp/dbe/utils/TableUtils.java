package com.zyp.dbe.utils;

/*
 * @Author: Ferapont
 * @Date: 2021/10/27 10:32
 * @PackageName: com.zyp.dbe.utils
 */

import com.zyp.dbe.controller.StudentController;
import com.zyp.dbe.pojo.Student;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class TableUtils {
    private static StudentController sc = new StudentController();

    /**
     * 显示菜单
     */
    public static void showMenuTable() {
        System.out.println("========学生信息管理系统========");
        System.out.println("| 1.添加学生信息  2.查询学生信息  |");
        System.out.println("| 3.修改学生信息  4.删除学生信息  |");
        System.out.println("| 5.添加课程信息  6.查询课程信息  |");
        System.out.println("| 7.修改课程信息  8.删除课程信息  |");
        System.out.println("| 9.录入学生信息  10.查询学生绩点 |");
        System.out.println("| 11.修改学生成绩 12.删除学生成绩 |");
        System.out.println("| 13.按系查询某课程所有的成绩信息  |");
        System.out.println("| 14.按系对学生成绩进行排名附信息  |");
        System.out.println("| 15.按学号显示学生信息和选课信息  |");
        System.out.println("| 0.退出本学生管理系统           |");
        System.out.println("=============================");
        System.out.print("请输入你的选项: ");
    }

    public static void printInfo(String Sno) {
        Student s = sc.getStudentBySno(Sno);
        System.out.print("学号: " + s.getSno());
        System.out.print("\t姓名: " + s.getSname());
        System.out.print("\t性别: " + s.getSsex());
        System.out.print("\t年龄: " + s.getSage());
        System.out.print("\t所在院系: " + s.getSdept());
        System.out.print("\t奖学金: " + s.getSscholarship() + "\n");
    }


    public static List<List<String>> studentsTo2dList(List<Student> students) {
        List<List<String>> l = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        titles.add("学号");
        titles.add("姓名");
        titles.add("性别");
        titles.add("年龄");
        titles.add("所在系");
        titles.add("奖学金");
        l.add(titles);
        for (Student s : students) {
            List<String> list = new ArrayList<>();
            list.add(s.getSno());
            list.add(s.getSname());
            list.add(s.getSsex());
            list.add(String.valueOf(s.getSage()));
            list.add(s.getSdept());
            list.add(s.getSscholarship());
            l.add(list);
        }
        return l;
    }
}

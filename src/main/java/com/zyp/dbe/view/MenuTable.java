package com.zyp.dbe.view;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 12:02
 * @PackageName: com.zyp.dbe.view
 */

public class MenuTable {
    public void showMenuTable() {
        System.out.println("---------------学生课程系统---------------");
        System.out.println("学生类：");
        System.out.println("1、添加入学信息" + "\t" + "2、查询学生信息" + "\t" + "3、修改学生信息" + "\t" + "4、删除学生信息");
        System.out.println("课程类：");
        System.out.println("5、添加课程信息" + "\t" + "6、查询课程信息" + "\t" + "7、修改课程信息" + "\t" + "8、删除没有选课的课程信息");
        System.out.println("学生成绩类：");
        System.out.println("9、添加成绩信息" + "\t" + "10、查询成绩信息" + "\t" + "11、修改成绩信息" + "\t" + "12、删除成绩信息");
        System.out.println("其他：");
        System.out.println("13、院系学生成绩统计" + "\t" + "14、学生成绩排名");
        System.out.println("0、退出");
        System.out.println("请选择您要进行的操作(0~14)：");
    }
}

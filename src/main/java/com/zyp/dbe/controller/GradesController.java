package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/15 14:34
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.mapper.GradesMapper;
import com.zyp.dbe.pojo.Grades;
import com.zyp.dbe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GradesController {

    public void addGrades() {
        try {
            out.println("下面是添加成绩信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生的学号（9位数字）：");
            int studentID = scanner.nextInt();
            out.println("请输入课程的编号（5位数字）：");
            int courseID = scanner.nextInt();
            out.println("请输入学生的成绩：");
            int grade = scanner.nextInt();
            out.println("插入数据：" + studentID + " " + courseID + " " + grade);

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
            int res = mapper.addGrades(new Grades(studentID, courseID, grade));
            if (res > 0) out.println("插入成功！");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功插入1条数据元组！");
            out.println("----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getGrades() {
        try {
            out.println("下面是根据学号来查询学生成绩信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生学号(9位数字)：");
            int studentID = scanner.nextInt();
            out.print("查询学号为：" + studentID + "的学生成绩信息：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
            Grades grades = mapper.getGradesById(studentID);
            sqlSession.close();

            out.println("成功查询1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGrades() {
        try {
            out.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

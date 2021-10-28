package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/15 15:09
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.mapper.CourseMapper;
import com.zyp.dbe.mapper.GradesMapper;
import com.zyp.dbe.mapper.StudentMapper;
import com.zyp.dbe.pojo.Course;
import com.zyp.dbe.pojo.Grades;
import com.zyp.dbe.pojo.Student;
import com.zyp.dbe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TotalController {

    public void getGradeBySdept() {
        List<Short> gradeList = null;
        out.println("下面进行根据院系来查询学生成绩信息：");
        Scanner scanner = new Scanner(in);
        out.println("请输入您要查询的院系：");
        String Sdept = scanner.next();
        out.println("请输入您要查询的课程的编号(1或2位数字)：");
        String Cno = scanner.next();

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper m1 = sqlSession.getMapper(StudentMapper.class);
        GradesMapper m2 = sqlSession.getMapper(GradesMapper.class);
        List<Student> students = m1.getStudentBySdept(Sdept);
        for (Student student : students) {
            String studentName = student.getSname();
            String Sno = student.getSno();
            Grades grade = m2.getGradesBySnoAndCno(Sno, Cno);
            short tmp = grade.getGrade();
            out.println("成功查询" + Sdept + "院系的课程编号为" + Cno + "的成绩：");
            out.println("姓名为" + studentName + "的同学的课程成绩为：" + tmp);
            gradeList.add(tmp);
        }
        sqlSession.close();

        short bestGrade = 0, worstGrade = 0, fail = 0;
        double excelentRate = 0.0;
        short sum = 0, exce = 0, num = 0;
        for (short grade : gradeList) {
            sum = (short) (sum + grade);
            bestGrade = (short) Math.max(bestGrade, grade);
            worstGrade = (short) Math.min(worstGrade, grade);
            if (grade >= 80) exce++;
            if (grade < 60) fail++;
            num++;
        }
        double average = sum / num;
        out.println("平均成绩为" + average);
        out.println("最好成绩为" + bestGrade);
        out.println("最差成绩为" + bestGrade);
        out.println("优秀率为" + excelentRate);
        out.println("不及格人数为" + fail);
        out.println("--------------------------------------");
    }

    public void getRankBySdept() {
        out.println("下面进行根据院系来进行学生成绩排名，并且显示学生、课程和成绩信息：");
        Scanner scanner = new Scanner(in);
        out.println("请输入您要查询的院系：");
        String Sdept = scanner.next();

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper m1 = sqlSession.getMapper(StudentMapper.class);
        CourseMapper m2 = sqlSession.getMapper(CourseMapper.class);
        GradesMapper m3 = sqlSession.getMapper(GradesMapper.class);
        List<Student> students = m1.getStudentBySdept(Sdept);
        List<List<Course>> courses = null;
        List<List<Grades>> grades = null;
        for (Student student : students) {
            String Sno = student.getSno();
            grades.add(m3.getGradesBySno(Sno));
            List<String> cnos = m3.getCnoBySno(Sno);

            List<Course> courseList = null;
            for (String cno : cnos) {
                Course course = m2.getCourseByCno(cno);
                courseList.add(course);
            }
            courses.add(courseList);
        }
        sqlSession.close();

        int size = students.size();
        for (int i = 1; i <= size; i++) {
            out.println("学生信息：");
            out.println(students.get(i));
            out.println("该学生的选课信息");
            out.println(courses.get(i));
            out.println("该学生的成绩信息");
            out.println(grades.get(i));
        }

        out.println("--------------------------------------");
    }

    public void getImformationBySno() {
        out.println("下面进行根据学号来查询学生基本信息和选课信息：");
        Scanner scanner = new Scanner(in);
        out.println("请输入您要查询的学生学号：");
        String id = scanner.next();
        List<Course> courseList = null;

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper m1 = sqlSession.getMapper(StudentMapper.class);
        CourseMapper m2 = sqlSession.getMapper(CourseMapper.class);
        GradesMapper m3 = sqlSession.getMapper(GradesMapper.class);
        Student student = m1.getStudentBySno(id);
        List<Grades> gradesList = m3.getGradesBySno(id);
        for (Grades grades : gradesList) {
            String cno = grades.getCno();
            Course course = m2.getCourseByCno(cno);
            courseList.add(course);
        }
        sqlSession.close();

        out.println("该学生基本信息如下：");
        out.println(student);
        out.println("选课信息如下：");
        out.println(courseList);
        out.println("--------------------------------------");
    }

}

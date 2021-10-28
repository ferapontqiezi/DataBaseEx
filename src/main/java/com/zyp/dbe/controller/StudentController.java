package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 12:20
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.mapper.StudentMapper;
import com.zyp.dbe.pojo.Student;
import com.zyp.dbe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class StudentController {
    public Student getStudentById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student s = mapper.getStudentById(id);
        sqlSession.commit();
        sqlSession.close();
        return s;
    }

    public void addStudent() {
        try {
            out.println("下面是增添新生入学信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生姓名：");
            String name = scanner.next();
            out.println("请输入学生学号(9位数字)：");
            int id = scanner.nextInt();
            out.println("请输入学生性别(男/女)：");
            String sex = scanner.next();
            out.println("请输入学生年龄：");
            int age = scanner.nextInt();
            out.println("请输入学生电话：");
            String tel = scanner.next();
            out.println("请输入学生住址：");
            String addr = scanner.next();
            out.println("请输入学生专业：");
            String major = scanner.next();
            out.println("插入数据：" + name + " " + id + " " + sex + " " + age + " " + tel + " " + addr + " " + major);

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int res = mapper.addStudent(new Student(name, id, sex, age, tel, addr, major));
            if (res > 0) out.println("增加学生成功！");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功插入1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudent() {
        try {
            out.println("下面是根据学号来查询学生信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生学号(9位数字)：");
            int id = scanner.nextInt();
            out.print("查询学号为：" + id + "的学生：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getStudentById(id);
            out.println(student);
            sqlSession.close();

            out.println("成功查询1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        try {
            out.println("下面是根据学号来修改学生信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生学号(9位数字)：");
            int id = scanner.nextInt();
            out.println("接下来要修改学号为：" + id + "的学生：");
            out.println("请输入修改后的学生姓名：");
            String name = scanner.next();
            out.println("请输入修改后的学生性别(男/女)：");
            String sex = scanner.next();
            out.println("请输入修改后的学生年龄：");
            int age = scanner.nextInt();
            out.println("请输入修改后的学生电话：");
            String tel = scanner.next();
            out.println("请输入修改后的学生住址：");
            String addr = scanner.next();
            out.println("请输入修改后的学生专业：");
            String major = scanner.next();

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int res = mapper.updateStudent(new Student(name, id, sex, age, tel, addr, major));
            if (res > 0) out.println("修改学生成功");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功修改1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        try {
            out.println("下面是根据学号来修改学生信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生学号(9位数字)：");
            int id = scanner.nextInt();
            out.println("删除学号为：" + id + "的学生：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int res = mapper.deleteStudent(id);
            if (res > 0) System.out.println("删除学生成功");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功删除1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

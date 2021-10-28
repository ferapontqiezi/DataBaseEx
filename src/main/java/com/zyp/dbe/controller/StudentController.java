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

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class StudentController {
    @SuppressWarnings("all")
    public List<Student> getStudentList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudentList();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @SuppressWarnings("all")
    public Student getStudentBySno(String Sno) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student s = mapper.getStudentBySno(Sno);
        sqlSession.commit();
        sqlSession.close();
        return s;
    }

    @SuppressWarnings("all")
    public Student getStudentBySdept(String Sdept) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student s = mapper.getStudentBySno(Sdept);
        sqlSession.commit();
        sqlSession.close();
        return s;
    }

    public void addStudent() {
        try {
            out.println("下面是增添新生入学信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生姓名：");
            String Sname = scanner.next();
            out.println("请输入学生学号(9位数字)：");
            String Sno = scanner.next();
            out.println("请输入学生性别(男/女)：");
            String Ssex = scanner.next();
            out.println("请输入学生年龄：");
            short Sage = scanner.nextShort();
            out.println("请输入学生院系：");
            String Sdept = scanner.next();
            out.println("请输入学生是否得过奖学金(是/否)：");
            String Sscholarship = scanner.next();
            out.println("插入数据：" + Sname + " " + Sno + " " + Ssex + " " + Sage + " " + Sdept + " " + Sscholarship);

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int res = mapper.addStudent(new Student(Sno, Sname, Ssex, Sage, Sdept, Sscholarship));
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
            String Sno = scanner.next();
            out.print("查询学号为：" + Sno + "的学生：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getStudentBySno(Sno);
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
            String Sno = scanner.next();
            out.println("接下来要修改学号为：" + Sno + "的学生：");
            out.println("请输入修改后的学生姓名：");
            String Sname = scanner.next();
            out.println("请输入修改后的学生性别(男/女)：");
            String Ssex = scanner.next();
            out.println("请输入修改后的学生年龄：");
            short Sage = scanner.nextShort();
            out.println("请输入修改后的学生院系：");
            String Sdept = scanner.next();
            out.println("请输入修改后的学生是否得过奖学金(是/否)：");
            String Sscholarship = scanner.next();
            out.println("插入数据：" + Sname + " " + Sno + " " + Ssex + " " + Sage + " " + Sdept + " " + Sscholarship);

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int res = mapper.updateStudent(new Student(Sno, Sname, Ssex, Sage, Sdept, Sscholarship));
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
            String Sno = scanner.next();
            out.println("删除学号为：" + Sno + "的学生：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int res = mapper.deleteStudent(Sno);
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

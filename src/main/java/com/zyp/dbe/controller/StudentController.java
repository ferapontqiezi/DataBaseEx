package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 12:20
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.mapper.StudentMapper;
import com.zyp.dbe.pojo.Grades;
import com.zyp.dbe.pojo.Student;
import com.zyp.dbe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class StudentController {
    GradesController gc = new GradesController();
    CourseController cc = new CourseController();

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
    public List<Student> getStudentBySdept(String Sdept) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> ans = mapper.getStudentBySdept(Sdept);
        sqlSession.commit();
        sqlSession.close();
        return ans;
    }

    @SuppressWarnings("all")
    public List<String> getCourses(String Sno) {
        Student s = getStudentBySno(Sno);
        List<String> cnos = gc.getCnoBySno(Sno);
        List<String> courses = new ArrayList<>();
        for (String st : cnos) {
            courses.add(cc.getCourseByCno(st).getCname());
        }
        return courses;
    }

    @SuppressWarnings("all")
    public String getStudentAverageGrade(String Sno) {
        List<Grades> grades = gc.getGradesBySno(Sno);
        short sum = 0;
        int n = 0;
        for (Grades grade : grades) {
            short temp = grade.getGrade();
            sum += temp;
            n++;
        }
        double ans = sum / n;
        return String.valueOf(ans);
    }

    @SuppressWarnings("all")
    Map<String, String> getCourseAndGrade(String sno) {
        Map<String, String> ans = new HashMap<String, String>();
        List<Grades> list = gc.getGradesBySno(sno);
        for (Grades s : list) {
            ans.put(cc.getCourseByCno(s.getCno()).getCname(), String.valueOf(s.getGrade()));
        }
        return ans;
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
            out.println("修改数据：" + Sname + " " + Sno + " " + Ssex + " " + Sage + " " + Sdept + " " + Sscholarship);

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

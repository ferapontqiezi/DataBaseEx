package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 19:06
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.mapper.CourseMapper;
import com.zyp.dbe.pojo.Course;
import com.zyp.dbe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class CourseController {
    @SuppressWarnings("all")
    public List<Course> getCourseList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> list = mapper.getCourseList();
        sqlSession.commit();
        sqlSession.close();
        return list;
    }

    @SuppressWarnings("all")
    public Course getCourseByCno(String Cno) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        Course ans = mapper.getCourseByCno(Cno);
        sqlSession.commit();
        sqlSession.close();
        return ans;
    }

    public void addCourse() {
        try {
            out.println("下面是增添课程信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入课程名称：");
            String name = scanner.next();
            out.println("请输入课程编号(1或2位数字)：");
            String no = scanner.next();
            out.println("请输入该课程的先修课程编号(1或2位数字)：");
            String pno = scanner.next();
            out.println("请输入课程学分：");
            short credit = scanner.nextShort();
            out.println("插入数据：" + name + " " + no + " " + pno + " " + credit);

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            int res = mapper.addCourse(new Course(no, name, pno, credit));
            if (res > 0) out.println("增加课程成功！");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功插入1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCourseById() {
        try {
            out.println("下面是查询课程信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入课程编号(1或2位数字)：");
            String no = scanner.next();

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            Course course = mapper.getCourseByCno(no);
            out.println(course);
            sqlSession.close();

            out.println("成功查询1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCourse() {
        try {
            out.println("下面是根据编号修改课程信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入课程编号(1或2位数字)：");
            String no = scanner.next();
            out.println("接下来要修改编号为：" + no + "的课程：");
            out.println("请输入修改后的课程名称：");
            String name = scanner.next();
            out.println("请输入修改后的先修课程编号(1或2位数字)：");
            String pno = scanner.next();
            out.println("请输入修改后的课程学分：");
            short credit = scanner.nextShort();

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            int res = mapper.updateCourse(new Course(no, name, pno, credit));
            if (res > 0) out.println("修改学生成功");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功修改1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse() {
        try {
            out.println("下面是根据课程编号来修改课程信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入课程编号(1或2位数字)：");
            String no = scanner.next();
            out.println("删除编号为：" + no + "的课程：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
            int res = mapper.deleteCourse(no);
            if (res > 0) System.out.println("删除课程成功");
            sqlSession.commit();
            sqlSession.close();

            out.println("成功删除1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

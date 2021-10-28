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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GradesController {
    @SuppressWarnings("all")
    List<Grades> getGradesList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
        List<Grades> list = mapper.getGradesList();
        sqlSession.close();
        return list;
    }

    @SuppressWarnings("all")
    List<Grades> getGradesBySno(String Sno) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
        List<Grades> list = mapper.getGradesBySno(Sno);
        sqlSession.close();
        return list;
    }

    @SuppressWarnings("all")
    List<String> getCnoBySno(String Sno) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
        List<String> list = mapper.getCnoBySno(Sno);
        sqlSession.close();
        return list;
    }

    @SuppressWarnings("all")
    List<String> getSnoByCno(String Cno) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
        List<String> list = mapper.getSnoByCno(Cno);
        sqlSession.close();
        return list;
    }

    public void addGrades() {
        try {
            out.println("下面是添加成绩信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入学生的学号（9位数字）：");
            String Sno = scanner.next();
            out.println("请输入课程的编号（1或2位数字）：");
            String Cno = scanner.next();
            out.println("请输入学生的成绩：");
            short grade = scanner.nextShort();
            out.println("插入数据：" + Sno + " " + Cno + " " + grade);

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
            int res = mapper.addGrades(new Grades(Sno, Cno, grade));
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
            String Sno = scanner.next();
            out.println("请输入课程的编号（1或2位数字）：");
            String Cno = scanner.next();
            out.println("查询学号为：" + Sno + "的学生的课程编号为" + Cno + "的学生成绩信息：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("Sno", Sno);
            map.put("Cno", Cno);
            Grades grade = mapper.getGradesBySnoAndCno(map);
            int ans = grade.getGrade();
            out.println(ans);
            sqlSession.close();

            out.println("成功查询1条数据元组！");
            out.println("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateGrades() {
        try {
            out.println("下面是根据学号和课程编号来修改学生成绩信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入原学生学号(9位数字)：");
            String Sno = scanner.next();
            out.println("请输入原课程的编号（1或2位数字）：");
            String Cno = scanner.next();
            out.println("修改学号为：" + Sno + "的学生的课程编号为" + Cno + "的成绩信息：");
            out.println("请输入修改后课程的分数：");
            short grade = scanner.nextShort();

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
            int res = mapper.updateGrades(new Grades(Sno, Cno, grade));
            if (res > 0) out.println("修改成功！");
            sqlSession.commit();
            sqlSession.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteGrades() {
        try {
            out.println("下面是根据学号和课程编号来删除学生成绩信息：");
            Scanner scanner = new Scanner(in);
            out.println("请输入原学生学号(9位数字)：");
            String Sno = scanner.next();
            out.println("请输入原课程的编号（1或2位数字）：");
            String Cno = scanner.next();
            out.print("删除学号为：" + Sno + "的学生的课程编号为" + Cno + "的成绩信息：");

            SqlSession sqlSession = MybatisUtils.getSqlSession();
            GradesMapper mapper = sqlSession.getMapper(GradesMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("Sno", Sno);
            map.put("Cno", Cno);
            int res = mapper.deleteGrades(map);
            if (res > 0) out.println("删除成功！");
            sqlSession.commit();
            sqlSession.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

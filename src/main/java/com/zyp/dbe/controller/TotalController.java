package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/15 15:09
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.mapper.TotalMapper;
import com.zyp.dbe.pojo.Grades;
import com.zyp.dbe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TotalController {

    public void getGradeByMajor() {
        out.println("下面进行根据专业来查询学生成绩信息：");
        out.println("请输入您要查询的专业：");
        Scanner scanner = new Scanner(in);
        String major = scanner.next();

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TotalMapper mapper = sqlSession.getMapper(TotalMapper.class);
        List<Grades> list = mapper.getGradeByMajor(major);
        sqlSession.close();

        out.println("成功查询" + major + "专业的学生成绩：");
        for (Grades ele : list) out.println(ele);
        out.println("--------------------------------------");
    }


}

package com.zyp.dbe.mapper;

/*
 * @Author: Ferapont
 * @Date: 2021/10/15 14:36
 * @PackageName: com.zyp.dbe.mapper
 */

import com.zyp.dbe.pojo.Grades;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface GradesMapper {

    List<Grades> getGradesList();

    List<Grades> getGradesBySno(String Sno);

    List<String> getCnoBySno(String Sno);

    List<String> getSnoByCno(String Cno);

    Grades getGradesBySnoAndCno(Map<String, Object> map);

    int addGrades(Grades grades);

    int updateGrades(Grades grades);

    int deleteGrades(Map<String, Object> map);
}

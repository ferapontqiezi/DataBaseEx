package com.zyp.dbe.mapper;

/*
 * @Author: Ferapont
 * @Date: 2021/10/18 17:37
 * @PackageName: com.zyp.dbe.mapper
 */

import com.zyp.dbe.pojo.Grades;

import java.util.List;

public interface TotalMapper {

    List<Grades> getGradeByMajor(String major);


}

package com.zyp.dbe.mapper;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 10:23
 * @PackageName: com.zyp.dbe.mapper
 */

import com.zyp.dbe.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生
    List<Student> getStudentList();

    //根据id查询学生
    Student getStudentById(int id);

    //添加学生
    int addStudent(Student student);

    //根据id更新学生
    int updateStudent(Student student);

    //根据id删除学生
    int deleteStudent(int id);
}

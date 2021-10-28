package com.zyp.dbe.mapper;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 10:23
 * @PackageName: com.zyp.dbe.mapper
 */

import com.zyp.dbe.pojo.Student;

import java.util.List;

@SuppressWarnings("all")
public interface StudentMapper {
    /**
     * //查询所有学生
     *
     * @return 学生列表
     */
    List<Student> getStudentList();

    /**
     * //根据id查询学生
     *
     * @param Sno
     * @return 学生
     */
    Student getStudentBySno(String Sno);

    /**
     * //根据院系查询学生
     *
     * @param Sdept
     * @return 学生列表
     */
    List<Student> getStudentBySdept(String Sdept);

    /**
     * //添加学生
     *
     * @param student
     * @return 添加个数
     */
    int addStudent(Student student);

    /**
     * //根据id更新学生
     *
     * @param student
     * @return 修改个数
     */
    int updateStudent(Student student);

    /**
     * //根据id删除学生
     *
     * @param Sno
     * @return 删除个数
     */
    int deleteStudent(String Sno);
}

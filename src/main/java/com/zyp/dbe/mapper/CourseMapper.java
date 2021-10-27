package com.zyp.dbe.mapper;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 18:57
 * @PackageName: com.zyp.dbe.mapper
 */

import com.zyp.dbe.pojo.Course;

import java.util.List;

public interface CourseMapper {

    /**
     * //查询所有课程
     *
     * @return 课程列表
     */
    List<Course> getCourseList();

    /**
     * //根据id查询课程
     *
     * @param id
     * @return 课程
     */
    Course getCourseById(int id);

    /**
     * //添加课程
     *
     * @param course
     * @return 增添课程数量
     */
    int addCourse(Course course);

    /**
     * //根据id更新课程
     *
     * @param course
     * @return 修改课程数量
     */
    int updateCourse(Course course);

    /**
     * //根据id删除课程
     *
     * @param id
     * @return 删除课程数量
     */
    int deleteCourse(int id);
}

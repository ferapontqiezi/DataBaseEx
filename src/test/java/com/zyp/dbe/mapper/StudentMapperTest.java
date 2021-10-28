//package com.zyp.dbe.mapper;
//
///*
// * @Author: Ferapont
// * @Date: 2021/10/14 10:29
// * @PackageName: com.zyp.dbe.mapper
// */
//
//import com.zyp.dbe.pojo.Student;
//import com.zyp.dbe.utils.MybatisUtils;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.List;
//
//public class StudentMapperTest {
//
//    @Test
//    public void test() {
//
//        //获得sqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        //getMapper
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList = mapper.getStudentList();
//
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//
//        //关闭sqlSession
//        sqlSession.close();
//    }
//
//    @Test
//    public void Retrieve() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.getStudentById(201916032);
//        System.out.println(student);
//
//        sqlSession.close();
//    }
//
//    @Test
//    public void Create() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        int res = mapper.addStudent(new Student("张三", 201911111, "男", 20, "13562347890", "主校区", "光电"));
//        if (res > 0) System.out.println("增加学生成功！");
//
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void Update() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        int res = mapper.updateStudent(new Student("李四", 201911111, "男", 20, "13562347890", "主校区", "光电"));
//        if (res > 0) System.out.println("修改学生成功");
//
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void Delete() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        int res = mapper.deleteStudent(201911111);
//        if (res > 0) System.out.println("删除学生成功");
//
//        sqlSession.commit();
//        sqlSession.close();
//    }
//}

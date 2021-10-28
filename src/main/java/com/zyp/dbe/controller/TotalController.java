package com.zyp.dbe.controller;

/*
 * @Author: Ferapont
 * @Date: 2021/10/15 15:09
 * @PackageName: com.zyp.dbe.controller
 */

import com.zyp.dbe.pojo.Student;
import com.zyp.dbe.utils.PrintTableUtils;
import com.zyp.dbe.utils.TableUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class TotalController {
    StudentController sc = new StudentController();
    GradesController gc = new GradesController();
    CourseController cc = new CourseController();

    public void getGradeBySystem() {
        List<Short> gradeList = new ArrayList<>();
        out.println("下面进行根据院系来查询学生成绩信息：");
        Scanner scanner = new Scanner(in);
        out.println("请输入您要查询的院系：");
        String Sdept = scanner.next();
        out.println("请输入您要查询的课程的编号(1或2位数字)：");
        String Cno = scanner.next();

        new PrintTableUtils(getAll(Cno)).printTable();

        /*
        short bestGrade = 0, worstGrade = 0, fail = 0;
        double excelentRate = 0.0;
        short sum = 0, exce = 0, num = 0;
        for (short grade : gradeList) {
            sum = (short) (sum + grade);
            bestGrade = (short) Math.max(bestGrade, grade);
            worstGrade = (short) Math.min(worstGrade, grade);
            if (grade >= 80) exce++;
            if (grade < 60) fail++;
            num++;
        }
        double average = sum / num;
        out.println("平均成绩为" + average);
        out.println("最好成绩为" + bestGrade);
        out.println("最差成绩为" + bestGrade);
        out.println("优秀率为" + excelentRate);
        out.println("不及格人数为" + fail);
        out.println("--------------------------------------");
        */
    }

    public void getRankBySdept() {
        out.println("下面进行根据院系来进行学生成绩排名，并且显示学生、课程和成绩信息：");
        Scanner scanner = new Scanner(in);
        out.println("请输入您要查询的院系：");
        String Sdept = scanner.next();
        List<Student> students = sc.getStudentBySdept(Sdept);
        List<SnoAndAvgGrade> list = new ArrayList<>();
        for (Student s : students) {
            list.add(new SnoAndAvgGrade(s.getSno(), sc.getStudentAverageGrade(s.getSno())));
        }
        Collections.sort(list, (s1, s2) -> {
            if (new Double(s1.getAvg()).compareTo(new Double(s2.getAvg())) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        int count = 1;
        System.out.println("===========================================================================");
        for (SnoAndAvgGrade l : list) {
            Map<String, String> cag = sc.getCourseAndGrade(l.getSno());
            System.out.println("第" + (count++) + "名: " + l.getAvg());
            TableUtils.printInfo(l.getSno());
            System.out.println("所选课程及成绩:");
            for (String key : cag.keySet()) {
                System.out.print(key + ":" + cag.get(key) + "\t");
            }
            System.out.println();
            System.out.println("===========================================================================");
        }

                /*
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper m1 = sqlSession.getMapper(StudentMapper.class);
        GradesMapper m2 = sqlSession.getMapper(GradesMapper.class);
        List<Student> students = m1.getStudentBySdept(Sdept);
        for (Student student : students) {
            String studentName = student.getSname();
            String Sno = student.getSno();
            Map<String, Object> map = new HashMap<>();
            map.put("Sno", Sno);
            map.put("Cno", Cno);
            Grades grade = m2.getGradesBySnoAndCno(map);
            short tmp = grade.getGrade();
            out.println("成功查询" + Sdept + "院系的课程编号为" + Cno + "的成绩：");
            out.println("姓名为" + studentName + "的同学的课程成绩为：" + tmp);
            gradeList.add(tmp);
        }
        sqlSession.close();
        */

        out.println("--------------------------------------");
    }

    public void getImformationBySno() {
        out.println("下面进行根据学号来查询学生基本信息和选课信息：");
        Scanner scanner = new Scanner(in);
        out.println("请输入您要查询的学生学号：");
        String Sno = scanner.next();

        TableUtils.printInfo(Sno);
        List<String> courses = sc.getCourses(Sno);
        System.out.println("所选课程: " + courses.toString());
    }

    public List<List<String>> getAll(String Cno) {
        List<List<String>> ans = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("系别");
        title.add("平均成绩");
        title.add("最好成绩");
        title.add("最差成绩");
        title.add("优秀率(>=80分)");
        title.add("不及格(<60分)人数");
        ans.add(title);

        List<String> snos = gc.getSnoByCno(Cno);
        Map<String, MyList> map = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        for (String s : snos) {
            Student student = sc.getStudentBySno(s);
            String Sdept = student.getSdept();
            temp.put("Sno", s);
            temp.put("Cno", Cno);
            int grade = gc.getGradesBySnoAndCno(temp);
            if (map.containsKey(Sdept)) {
                MyList myList = map.get(Sdept);
                int total = myList.getTotal();
                double avg = myList.getAvg();
                int best = myList.getBest();
                int worst = myList.getWorst();
                int countOfGood = myList.getCountOfGood();
                int countOfNotPass = myList.getCountOfNotPass();
                myList.setTotal(total + 1);
                myList.setAvg((avg * total + grade) / (total + 1));
                if (grade > myList.getBest()) {
                    myList.setBest(grade);
                }
                if (grade < myList.getWorst()) {
                    myList.setWorst(grade);
                }
                if (grade >= 80) {
                    myList.setCountOfGood(countOfGood + 1);
                }
                if (grade < 60) {
                    myList.setCountOfNotPass(countOfNotPass + 1);
                }
            } else {
                MyList myList = new MyList(1, grade, grade, grade, 0, 0);
                if (grade >= 80) {
                    myList.setCountOfGood(1);
                }
                if (grade < 60) {
                    myList.setCountOfNotPass(1);
                }
                map.put(Sdept, myList);
            }

        }
        for (String key : map.keySet()) {
            List<String> row = new ArrayList<>();
            MyList myList = map.get(key);
            row.add(key);
            DecimalFormat df = new DecimalFormat("0.00");
            String avg = df.format(BigDecimal.valueOf(myList.getAvg()));
            row.add(avg);
            row.add(String.valueOf(myList.getBest()));
            row.add(String.valueOf(myList.getWorst()));
            String goodpercent = df.format(BigDecimal.valueOf((double) myList.getCountOfGood() / myList.getTotal()));
            row.add(goodpercent);
            row.add(String.valueOf(myList.getCountOfNotPass()));
            ans.add(row);
        }
        return ans;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class SnoAndAvgGrade {

    private String Sno;

    private String avg;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class MyList {
    private int total;

    private double avg;

    private int best;

    private int worst;

    private int countOfGood;

    private int countOfNotPass;
}
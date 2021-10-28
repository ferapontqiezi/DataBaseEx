package com.zyp.dbe;

/*
 * @Author: Ferapont
 * @Date: 2021/10/14 12:00
 * @PackageName: com.zyp.dbe
 */

import com.zyp.dbe.controller.CourseController;
import com.zyp.dbe.controller.GradesController;
import com.zyp.dbe.controller.StudentController;
import com.zyp.dbe.controller.TotalController;
import com.zyp.dbe.utils.TableUtils;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        TableUtils tu = new TableUtils();
        StudentController sc = new StudentController();
        CourseController cc = new CourseController();
        GradesController gc = new GradesController();
        TotalController tc = new TotalController();
        tu.showMenuTable();
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        while (op != 0) {
            switch (op) {
                case 1:
                    sc.addStudent();
                    break;
                case 2:
                    sc.getStudent();
                    break;
                case 3:
                    sc.updateStudent();
                    break;
                case 4:
                    sc.deleteStudent();
                    break;
                case 5:
                    cc.addCourse();
                    break;
                case 6:
                    cc.getCourseById();
                    break;
                case 7:
                    cc.updateCourse();
                    break;
                case 8:
                    cc.deleteCourse();
                    break;
                case 9:
                    gc.addGrades();
                    break;
                case 10:
                    gc.getGrades();
                    break;
                case 11:
                    gc.updateGrades();
                    break;
                case 12:
                    gc.deleteGrades();
                    break;
                case 13:
                    tc.getGradeBySystem();
                    break;
                case 14:
                    tc.getRankBySdept();
                    break;
                case 15:
                    tc.getImformationBySno();
                    break;

                default:
                    break;
            }
            tu.showMenuTable();
            op = scanner.nextInt();
        }
    }
}

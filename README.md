# 数据库实验

> 实验环境：
>
> * `java`:`jdk11.0.11`
> * `mysql`驱动：`mysql-connector-java-8.0.22.jar`
> * `mysql`数据库：`MySQL Server 5.7`
> * 操作系统：`Windows 10`
> * 框架：`mybatis 3.5.2`

## 数据库说明

数据库有三个表，Student、Course、Grades，各个表的字段信息如下：

**Student**（varchar长度适当即可）

~~~sql
+-------------+----------------+-----------+
| COLUMN_NAME | COLUMN_COMMENT | DATA_TYPE |
+-------------+----------------+-----------+
| name        |                | int       |
| id          |                | varchar   |
| sex         |                | varchar   |
| age         |                | varchar   |
| tel         |                | varchar   |
| addr        |                | varchar   |
+-------------+----------------+-----------+
~~~

**Course**（varchar长度适当即可）

~~~mysql
+-------------+----------------+-----------+
| COLUMN_NAME | COLUMN_COMMENT | DATA_TYPE |
+-------------+----------------+-----------+
| name        |                | varchar   |
| id          |                | int       |
| credit      |                | varchar   |
+-------------+----------------+-----------+
~~~

**Grades**（varchar长度适当即可）

~~~
+-------------+----------------+-----------+
| COLUMN_NAME | COLUMN_COMMENT | DATA_TYPE |
+-------------+----------------+-----------+
| studentName |                | varchar   |
| studentName |                | varchar   |
| grade       |                | int       |
+-------------+----------------+-----------+
~~~

## 应用预览

> 其实就是一个while循环里嵌套一个switch，实现一个命令行菜单，大佬勿喷
>
> 实现功能：
>
> **学生类**
> 1.新生入学信息增加  2.学生信息删除  3.查询所有学生信息  4.学生信息修改
> **课程类**
> 5.增加新课程  6.删除没有选课的课程信息  7.查询课程信息  8.修改课程信息
> **学生成绩类**
> 9.录入学生成绩  10.删除学生成绩  11.查询所有学生成绩  12.修改学生成绩
> **其他**
> 13.院系学生成绩统计  14.学生成绩排名  15.查询学生基本信息和选课信息  0.查看菜单

实现了如下一个查询菜单：

![image-20201120000411254](E:\StudentSqlwithJdbc-main\StudentSqlwithJdbc-main\image\image-20201120000411254.png)

比如输入13，查询院系学生成绩统计信息

![image-20201120000604000](E:\StudentSqlwithJdbc-main\StudentSqlwithJdbc-main/image/image-20201120000604000.png)
package com.rong;
//java 类名首字母大写 驼峰式 ChengDuStudent
//方法 首字母小写(构造方法除外) doServlet
//常量 划线式 全大写
public class Student {
    public static final String MY_SCHOOL = "XXX大学";
    private String name;
    private String stu;
    private String sex;

    public Student() {
    }

    public Student(String name, String stu, String sex) {
        this.name = name;
        this.stu = stu;
        this.sex = sex;
    }

}

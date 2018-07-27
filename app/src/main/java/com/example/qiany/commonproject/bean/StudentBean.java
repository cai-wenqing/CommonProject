package com.example.qiany.commonproject.bean;

/**
 * @author caiwenqing
 * @data 2018/7/11
 * description:
 */
public class StudentBean {

    public String name;

    public StudentBean(String name) {
        this.name = name;
    }

    public void release() {
        System.out.println("StudentBean：release");
    }
}

package com.rapid.androidndktest.data;

/**
 * Created by iliyan on 16.09.17.
 */

public class Student extends Person {
    private float mAverageMark;
    private int mGrade;
    private String mStudentId;

    public Student(String name, String personalId, int age, float averageMark, int grade, String studentId) {

        super(name, personalId, age);
        mAverageMark = averageMark;
        mGrade = grade;
        mStudentId = studentId;
    }

    public float getAverageMark() {
        return mAverageMark;
    }

    public int getGrade() {
        return mGrade;
    }

    public String getStudentId() {
        return mStudentId;
    }
}

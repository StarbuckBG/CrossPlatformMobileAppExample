package com.rapid.androidndktest.data;

/**
 * Created by iliyan on 16.09.17.
 */

public class Worker extends Person {
    private float mPricePerHour;
    private float mProductivityCoef;
    private int mWorkExperience;

    public Worker(String name, String personalId, int age, float pricePerHour, float productivityCoef, int workExperience) {
        super(name, personalId, age);
        mPricePerHour = pricePerHour;
        mProductivityCoef = productivityCoef;
        mWorkExperience = workExperience;
    }

    public float getPricePerHour() {
        return mPricePerHour;
    }

    public float getProductivityCoef() {
        return mProductivityCoef;
    }

    public int getWorkExperience() {
        return mWorkExperience;
    }
}

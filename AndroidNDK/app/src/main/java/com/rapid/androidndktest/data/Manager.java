package com.rapid.androidndktest.data;

import java.util.List;

/**
 * Created by iliyan on 16.09.17.
 */

public class Manager extends Worker {
    private List<Worker> mWorkers;

    public Manager(String name, String personalId, int age, float pricePerHour, float productivityCoef, int workExperience, List<Worker> workers) {
        super(name, personalId, age, pricePerHour, productivityCoef, workExperience);
        mWorkers = workers;
    }

    public List<Worker> getWorkers() {
        return mWorkers;
    }
}

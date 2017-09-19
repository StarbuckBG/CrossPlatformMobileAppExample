package com.rapid.androidndktest.data;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by iliyan on 16.09.17.
 */

public class Person implements Serializable {
    private String mName;
    private String mPersonalId;
    private int mAge;

    public Person(String name, String personalId, int age) {
        mName = name;
        mPersonalId = personalId;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getPersonalId() {
        return mPersonalId;
    }

    public int getAge() {
        return mAge;
    }
}

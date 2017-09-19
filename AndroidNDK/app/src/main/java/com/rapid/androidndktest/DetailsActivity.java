package com.rapid.androidndktest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rapid.androidndktest.data.Manager;
import com.rapid.androidndktest.data.Person;
import com.rapid.androidndktest.data.Student;
import com.rapid.androidndktest.data.Worker;

public class DetailsActivity extends AppCompatActivity {
    private static final String EXTRA_PERSON = "person_extra";
    private Person mPerson;
    private TextView vAgeText;
    private TextView vPersonalIdText;
    private TextView vNameText;
    private TextView vHolder1Text;
    private TextView vHolder2Text;
    private TextView vHolder3Text;

    public static void startScreen(@NonNull Context context, @NonNull Person person) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(EXTRA_PERSON, person);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        readArguments(getIntent());
        setup();
        displayPerson();
    }

    private void readArguments(Intent intent) {
        mPerson = (Person) intent.getSerializableExtra(EXTRA_PERSON);
        if (mPerson == null) {
            throw new IllegalArgumentException(EXTRA_PERSON + " is required!");
        }
    }

    private void setup() {
        vAgeText = (TextView) findViewById(R.id.details_age_text_view);
        vPersonalIdText = (TextView) findViewById(R.id.details_personal_id_text_view);
        vNameText = (TextView) findViewById(R.id.details_name_text_view);
        vHolder1Text = (TextView) findViewById(R.id.details_holder1_view);
        vHolder2Text = (TextView) findViewById(R.id.details_holder2_view);
        vHolder3Text = (TextView) findViewById(R.id.details_holder3_view);
    }

    private void displayPerson() {
        vAgeText.setText("Age: " + mPerson.getAge());
        vPersonalIdText.setText("Personal id: " + mPerson.getPersonalId());
        vNameText.setText("Name: " + mPerson.getName());
        if (mPerson instanceof Student) {
            displayStudent(((Student) mPerson));
        } else if (mPerson instanceof Worker) {
            displayWorker(((Worker) mPerson));
            if (mPerson instanceof Manager) {
                displayManager(((Manager) mPerson));
            }
        }
    }

    private void displayStudent(Student student) {
        vHolder1Text.setText("grade: " + student.getGrade());
        vHolder2Text.setText("averageMark: " + student.getAverageMark());
        vHolder3Text.setText("studentId: " + student.getStudentId());
    }

    private void displayWorker(Worker worker) {
        vHolder1Text.setText("Productivity coeff: " + worker.getProductivityCoef());
        vHolder2Text.setText("Price per hour: " + worker.getPricePerHour());
        vHolder3Text.setText("Work exp: " + worker.getWorkExperience());
    }

    private void displayManager(Manager manager) {
        TextView workersText = (TextView) findViewById(R.id.details_holder4_view);
        workersText.setVisibility(View.VISIBLE);
        String workerNames = "";
        for (Worker worker : manager.getWorkers()) {
            workerNames += worker.getName() + ' ';
        }
        workersText.setText("Workers: " + workerNames);
    }
}

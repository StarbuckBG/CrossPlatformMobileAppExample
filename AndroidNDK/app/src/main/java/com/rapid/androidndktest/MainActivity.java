package com.rapid.androidndktest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rapid.androidndktest.data.Manager;
import com.rapid.androidndktest.data.Person;
import com.rapid.androidndktest.data.Student;
import com.rapid.androidndktest.data.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
//        System.loadLibrary("Manager");
//        System.loadLibrary("Person");
//        System.loadLibrary("Student");
//        System.loadLibrary("Worker");
//        System.loadLibrary("to_string");
    }

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
        displayData(retrieveData());
    }

    private void setup() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    private void displayData(@NonNull List<Person> persons) {
        mAdapter.display(persons);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String getPeople();

    @NonNull
    private List<Person> retrieveData() {
        //TODO: Use native getPeople() here
        return transform("mock");
    }

    @NonNull
    private List<Person> transform(@NonNull String nativeData) {
        //TODO: Implement method
        Student student1 = new Student("Ivan", "1232132", 14, 4.92f, 7, "8556544");
        Student student2 = new Student("Petar", "123211231", 16, 5.89f, 9, "8192379132133");
        Worker worker1 = new Worker("Geоrgi", "unknown", 31, 4.23f, 0.78f, 6);
        Worker worker2 = new Worker("Todor", "182937221", 29, 6.19f, 0.98f, 7);
        Worker worker3 = new Worker("Stefan", "91623187312", 26, 5.2f, 0.83f, 4);
        Manager manager = new Manager("Gergana", "123761823", 31, 14.3f, 0.99f, 9,
                Arrays.asList(worker1, worker2, worker3));
        return Arrays.asList(student1, student2, worker1, worker2, worker3, manager);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        @NonNull
        private final List<Person> mData;

        MyAdapter() {
            mData = new ArrayList<>();
        }

        void display(@NonNull List<Person> data) {
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View itemView = inflater.inflate(R.layout.person_row_layout, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Person person = mData.get(position);
            holder.display(person);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView vNameText;
            TextView vAgeText;

            MyViewHolder(View itemView) {
                super(itemView);
                vNameText = (TextView) itemView.findViewById(R.id.person_row_name_text_view);
                vAgeText = (TextView) itemView.findViewById(R.id.person_row_age_text_view);
                itemView.setOnClickListener(this);
            }

            void display(@NonNull Person person) {
                vNameText.setText(person.getName());
                vAgeText.setText("Age: " + person.getAge());
            }

            @Override
            public void onClick(View v) {
                int adapterPosition = getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Person person = mData.get(adapterPosition);
                    DetailsActivity.startScreen(v.getContext(), person);
                }
            }
        }
    }
}

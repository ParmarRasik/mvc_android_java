package com.demo.mvc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.demo.mvc.views.StudentView;

public class MainActivity extends AppCompatActivity {

    StudentView studentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentView = new StudentView(MainActivity.this, null);
        setContentView(studentView.getRootView());
        studentView.initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentView.loadStudentList();
    }
}
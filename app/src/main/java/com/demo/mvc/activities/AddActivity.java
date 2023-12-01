package com.demo.mvc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.demo.mvc.R;
import com.demo.mvc.views.StudentAddView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentAddView addView = new StudentAddView(this, null);
        setContentView(addView.getRootView());
        addView.initView();
    }
}
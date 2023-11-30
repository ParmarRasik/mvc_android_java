package com.demo.mvc.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.mvc.R;
import com.demo.mvc.controllers.StudentController;

public class StudentView {
    View mainView;
    StudentController controller;

    public StudentView(Context context, ViewGroup container) {
        this.mainView = LayoutInflater.from(context).inflate(R.layout.activity_main, container, false);
        this.controller = new StudentController(context, this);
    }

    public void initView(){

    }

    public View getRootView() {
        return mainView;
    }
}

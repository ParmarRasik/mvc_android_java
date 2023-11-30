package com.demo.mvc.controllers;

import android.content.Context;

import com.demo.mvc.models.StudentModel;
import com.demo.mvc.views.StudentView;

public class StudentController {
    private final StudentModel studentModel;
    private final StudentView studentView;
    public StudentController(Context context, StudentView studentView){

        this.studentModel = new StudentModel(context);
        this.studentView = studentView;
    }
}

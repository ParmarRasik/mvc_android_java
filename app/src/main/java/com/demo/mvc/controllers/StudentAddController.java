package com.demo.mvc.controllers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import com.demo.mvc.models.Student;
import com.demo.mvc.models.StudentModel;
import com.demo.mvc.views.StudentAddView;

public class StudentAddController {

    private final StudentModel studentModel;
    private final StudentAddView studentAddView;
    private final Context context;

    public StudentAddController(Context context, StudentAddView studentAddView) {
        this.studentModel = new StudentModel(context);
        this.studentAddView = studentAddView;
        this.context = context;
    }


    public void addStudent(String name, String city, String email) {
        if (name.isEmpty()) {
            Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show();
        } else if (city.isEmpty()) {
            Toast.makeText(context, "Please enter city", Toast.LENGTH_SHORT).show();
        } else if (!isValidEmail(email)) {
            Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show();
        } else {
            studentModel.insetStudent(new Student(0, name, email, city));
            studentAddView.resetView();
        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}

package com.demo.mvc.views;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.demo.mvc.R;
import com.demo.mvc.adapter.StudentListAdapter;
import com.demo.mvc.controllers.StudentController;
import com.demo.mvc.models.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class StudentView implements View.OnClickListener{
    View mainView;
    StudentController controller;
    RecyclerView rvStudent;
    FloatingActionButton fabAdd;
    Context context;

    public StudentView(Context context, ViewGroup container) {
        this.context = context;
        this.mainView = LayoutInflater.from(context).inflate(R.layout.activity_main, container, false);
        this.controller = new StudentController(context, this);
    }

    public void initView() {
        rvStudent = mainView.findViewById(R.id.rvStudent);
        fabAdd = mainView.findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(this);
    }

    public void loadStudentList(){
        controller.getStudents();
    }
    public View getRootView() {
        return mainView;
    }

    public void showStudentList(ArrayList<Student> arrayList){
        StudentListAdapter adapter = new StudentListAdapter(context, arrayList);
        rvStudent.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view == fabAdd){
        context.startActivity(new Intent());
        }
    }
}

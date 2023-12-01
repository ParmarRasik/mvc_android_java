package com.demo.mvc.views;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.demo.mvc.R;
import com.demo.mvc.controllers.StudentAddController;

public class StudentAddView implements View.OnClickListener {

    private final View mainView;
    private final StudentAddController controller;
    private final Context context;
    private AppCompatEditText etName, etCity, etEmail;
    private AppCompatButton btnAdd;

    public StudentAddView(Context context, ViewGroup container) {
        this.mainView = LayoutInflater.from(context).inflate(R.layout.activity_add, container, false);
        this.controller = new StudentAddController(context, this);
        this.context = context;
    }

    public void initView() {
        etName = mainView.findViewById(R.id.etName);
        etCity = mainView.findViewById(R.id.etCity);
        etEmail = mainView.findViewById(R.id.etEmail);
        btnAdd = mainView.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    public View getRootView() {
        return mainView;
    }

    public void resetView(){
        etName.setText("");
        etCity.setText("");
        etEmail.setText("");
    }

    @Override
    public void onClick(View view) {
        if (view == btnAdd) {
            controller.addStudent(etName.getText().toString(),etCity.getText().toString(),etEmail.getText().toString());
        }
    }
}

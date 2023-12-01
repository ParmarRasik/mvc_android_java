package com.demo.mvc.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.mvc.R;
import com.demo.mvc.models.Student;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private final Context context;
    private final ArrayList<Student> studentArrayList;

    public StudentListAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }


    @NonNull
    @Override
    public StudentListAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent,false);
        return new StudentViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull StudentListAdapter.StudentViewHolder holder, int position) {
        Student student = studentArrayList.get(position);
        holder.tvName.setText(student.getId() + ". " + student.getName());
        holder.tvEmail.setText("Email : " + student.getEmail());
        holder.tvEmail.setText("City : " + student.getCity());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

public class StudentViewHolder extends RecyclerView.ViewHolder{

    AppCompatTextView tvName;
    AppCompatTextView tvEmail;
    AppCompatTextView tvCity;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvEmail = itemView.findViewById(R.id.tvEmail);
        tvCity = itemView.findViewById(R.id.tvCity);
    }
}
}

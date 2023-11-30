package com.demo.mvc.models;

import static com.demo.mvc.utils.DatabaseHandler.COL_CITY;
import static com.demo.mvc.utils.DatabaseHandler.COL_EMAIL;
import static com.demo.mvc.utils.DatabaseHandler.COL_ID;
import static com.demo.mvc.utils.DatabaseHandler.COL_NAME;
import static com.demo.mvc.utils.DatabaseHandler.TABLE_STUDENT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.demo.mvc.utils.DatabaseHandler;

import java.util.ArrayList;

public class StudentModel {

    private static final String TAG = StudentModel.class.getSimpleName();
    DatabaseHandler databaseHandler;

    public StudentModel(Context context){
        databaseHandler = new DatabaseHandler(context);
    }
    public ArrayList<Student> getStudentList(){
        ArrayList<Student> studentArrayList = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.query(TABLE_STUDENT, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    // Fetch data from the cursor for each row
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME));
                    String email = cursor.getString(cursor.getColumnIndexOrThrow(COL_EMAIL));
                    String city = cursor.getString(cursor.getColumnIndexOrThrow(COL_CITY));
                    studentArrayList.add(new Student(id,name,email,city));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        Log.w(TAG, "getUploadedImageList: "+studentArrayList.size() );
        Log.w(TAG, "getUploadedImageList: "+studentArrayList);
        return studentArrayList;
    }

    public void insetStudent(Student student) {
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, student.getName());
        contentValues.put(COL_EMAIL, student.getEmail());
        contentValues.put(COL_CITY, student.getCity());
        long newRowId = db.insert(TABLE_STUDENT, null, contentValues);
        if(newRowId == -1){
            Log.e(TAG, "insertFileRecord: some error accrued");
        }else {
            Log.w(TAG, "insertFileRecord: "+ newRowId);
        }
        db.close();
    }
}

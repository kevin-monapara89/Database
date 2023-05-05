package com.kevin.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.nfc.Tag
import android.util.Log
import com.kevin.database.Model.StudentModel

class DbHelper(
    context: Context?,
) : SQLiteOpenHelper(context, "Data1.db", null, 1) {
    private val TAG = "DbHelper"
    val TABLE_NAME = "student"

    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, surname TEXT, std INT)"
        p0?.execSQL(sql)!!
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun addStudent(stdData : StudentModel) {
        var db = writableDatabase
        var values = ContentValues().apply {
            put("name",stdData.name)
            put("surname",stdData.surname)
            put("std",stdData.std)
        }
        var iss = db.insert(TABLE_NAME,null,values)
        if (iss.toInt() == -1){
            Log.e(TAG, "addStudents: ===================== Data is Not Inserted")
        } else {
            Log.e(TAG, "addStudents: ===================== Data is Inserted.///////////////////////")
        }

    }
}
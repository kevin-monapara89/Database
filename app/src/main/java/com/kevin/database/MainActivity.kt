package com.kevin.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kevin.database.Model.StudentModel
import com.kevin.database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dbHelper = DbHelper(this)
        binding.btnsubmit.setOnClickListener {
            var name = binding.edtname.text.toString()
            var surname = binding.edtsurname.text.toString()
            var std = binding.edtstd.text.toString()

            var data = StudentModel(0, name, surname, std)
            dbHelper.addStudent(data)
        }
    }
}
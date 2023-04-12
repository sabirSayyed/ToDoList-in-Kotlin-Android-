package com.radicaldevs.to_dolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.radicaldevs.to_dolist.rcAdapters.listAdapter
import com.radicaldevs.to_dolist.rcAdapters.listItemStructure
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tasks = ArrayList<listItemStructure>()

        val rcView:RecyclerView = findViewById(R.id.taskList)
        rcView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL,false)
        rcView.adapter = listAdapter(applicationContext,tasks)

        val addBtn: FloatingActionButton = findViewById(R.id.addTask)
        val task: TextView = findViewById(R.id.task)

        addBtn.setOnClickListener{
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val current = LocalDateTime.now().format(formatter)

            tasks.add(listItemStructure(task.text.toString(),current.toString()))
            (rcView.adapter as listAdapter).notifyDataSetChanged()

        }
        

    }
}
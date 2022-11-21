package com.a5k.diary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.a5k.diary.R
import com.a5k.diary.databinding.ActivityMainBinding
import com.a5k.diary.domain.entity.Task
import com.a5k.diary.ui.custom.CalendarView
import com.a5k.diary.ui.custom.CustomeViewGroup
import com.a5k.diary.ui.custom.TaskView

class MainActivity : AppCompatActivity() {

    private var vb : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
       val lin = vb?.containerMm
        for (i in 0..23){
            lin?.addView(CalendarView(this).apply { setting(String.format("%02d:00", i)) })
        }
        val task = Task(id =1, date_start = 1668768932000, date_finish = 1668969532000, "Name Task", "Description task more info task")
        val task1 = Task(id =2, date_start = 1668981658000, date_finish = 1668984490000, "Name Task", "Description task more info task Description task more info task Description task more info task")

        val viewTask = TaskView(this).apply {
            settingViewTask(task, 2400)
        }
        val viewTask1 = TaskView(this).apply {
            settingViewTask(task1, 2400)
        }
        lin?.addView(viewTask)
        lin?.addView(viewTask1)
    }
}
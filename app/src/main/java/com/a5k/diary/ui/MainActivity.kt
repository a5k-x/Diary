package com.a5k.diary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.a5k.diary.R
import com.a5k.diary.databinding.ActivityMainBinding
import com.a5k.diary.ui.custom.CalendarView
import com.a5k.diary.ui.custom.CustomeViewGroup

class MainActivity : AppCompatActivity() {

    private var vb : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
       val lin = vb?.containerMm
        for (i in 1..24){
            lin?.addView(CalendarView(this).apply { setting(i.toString()) })
        }

    }
}
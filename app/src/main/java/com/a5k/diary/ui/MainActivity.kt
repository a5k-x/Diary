package com.a5k.diary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.a5k.diary.R
import com.a5k.diary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }
}
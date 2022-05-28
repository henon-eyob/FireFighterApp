package com.example.firefighterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout

class ObstacleAvoiding : AppCompatActivity() {
    private lateinit var obstacleStart:RelativeLayout
    private lateinit var obstacleStop:RelativeLayout
    private lateinit var obstacleBack:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_obstacle_avoiding)
        initView()
        obstacleBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun initView(){
        obstacleBack = findViewById(R.id.obstacleBack)
        obstacleStart = findViewById(R.id.obstacleStart)
        obstacleStop = findViewById(R.id.obstacleStop)
    }
}
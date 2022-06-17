package com.example.firefighterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import java.io.IOException

class SelfDriving : AppCompatActivity() {
    private lateinit var selfDrivingBack:ImageView
    private lateinit var selfDrivingStart:RelativeLayout
    private lateinit var selfDrivingStop:RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_self_driving)
        initView()
        selfDrivingBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        selfDrivingStart.setOnClickListener {
            val commod = 9
            try{
                MainActivity.outputStream.write(commod)
                Log.d(ObstacleAvoiding.TAG, "onCreate:Send Data ")
            }catch (e: IOException){
                e.printStackTrace()
                Log.d(ObstacleAvoiding.TAG, "onCreate: ${e.message}")
            }
        }
        selfDrivingStop.setOnClickListener {
            val commod = 0
            try{
                MainActivity.outputStream.write(commod)
                Log.d(ObstacleAvoiding.TAG, "onCreate:Send Data ")
            }catch (e: IOException){
                e.printStackTrace()
                Log.d(ObstacleAvoiding.TAG, "onCreate: ${e.message}")
            }
        }
    }

    private fun initView(){
        selfDrivingBack = findViewById(R.id.selfDrivingBack)
        selfDrivingStart = findViewById(R.id.selfDrivingStart)
        selfDrivingStop = findViewById(R.id.selfDrivingStop)
    }
}
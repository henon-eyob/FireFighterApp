package com.example.firefighterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import java.io.IOException

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
        obstacleStart.setOnClickListener {
            val command = 1
            Log.d(TAG, "onCreate: CLICKED ")
            try {
                MainActivity.outputStream.write(command)
                Log.d(TAG, "onCreate: CLICKED ")
            }catch (e:IOException){
                e.printStackTrace()
                Log.d(TAG, "onCreate: ${e.message}")
            }
        }
        obstacleStop.setOnClickListener {
            val commod = 0
            try{
                MainActivity.outputStream.write(commod)
                Log.d(TAG, "onCreate:Send Data ")
            }catch (e:IOException){
                e.printStackTrace()
                Log.d(TAG, "onCreate: ${e.message}")
            }
        }
    }

    private fun initView(){
        obstacleBack = findViewById(R.id.obstacleBack)
        obstacleStart = findViewById(R.id.obstacleStart)
        obstacleStop = findViewById(R.id.obstacleStop)
    }
    companion object{
        const val TAG = "OBSTACLE"
    }
}
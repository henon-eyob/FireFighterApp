package com.example.firefighterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import java.io.IOException
import java.util.jar.Manifest

class HumanFollowing : AppCompatActivity() {
    private lateinit var backImageView: ImageView
    private lateinit var humanStart:RelativeLayout
    private lateinit var humanStop:RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_human_following)
        initView()
        backImageView.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        humanStart.setOnClickListener {
            val commod = 7
            try{
                MainActivity.outputStream.write(commod)
                Log.d(ObstacleAvoiding.TAG, "onCreate:Send Data ")
            }catch (e: IOException){
                e.printStackTrace()
                Log.d(ObstacleAvoiding.TAG, "onCreate: ${e.message}")
            }

        }
        humanStop.setOnClickListener {
            val comand =0
            try {
                MainActivity.outputStream.write(comand)
                Log.d(TAG, "onCreate: SEND DATA")
            }catch (e:IOException){
                Log.d(TAG, "onCreate: ${e.message}")
            }

        }

    }

    private fun initView(){
        humanStart = findViewById(R.id.humanFollowingStart)
        humanStop = findViewById(R.id.humanFollowingEnd)
        backImageView = findViewById(R.id.humanFollowingBack)
    }

   companion object{
    const val TAG = "HUMAN FOLLOWING"

    }
}
package com.example.firefighterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
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

    }

    private fun initView(){
        humanStart = findViewById(R.id.humanFollowingStart)
        humanStop = findViewById(R.id.humanFollowingEnd)
        backImageView = findViewById(R.id.humanFollowingBack)
    }


}
package com.example.firefighterapp

import android.app.Service
import android.bluetooth.BluetoothClass
import android.content.Intent
import android.os.IBinder

class ServiceClass: Service() {



    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}
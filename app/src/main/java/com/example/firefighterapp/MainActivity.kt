package com.example.firefighterapp

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var humanFollowingCardView: CardView
    private lateinit var obstacleAvoidingCardView: CardView
    private lateinit var selfDrivingCardView: CardView
    private lateinit var bluetoothCardView: CardView
    private lateinit var bluetoothAdapter: BluetoothManager
    private lateinit var bluetoothSocket: BluetoothSocket
    private lateinit var constraintLayout:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        bluetoothAdapter = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        humanFollowingCardView.setOnClickListener {
            startActivity(Intent(this, HumanFollowing::class.java))
        }

        obstacleAvoidingCardView.setOnClickListener {
            startActivity(Intent(this, ObstacleAvoiding::class.java))
        }

        selfDrivingCardView.setOnClickListener {
            startActivity(Intent(this, SelfDriving::class.java))
        }

        bluetoothCardView.setOnClickListener {
            Common(this).checkPermission()
            if(bluetoothAdapter.adapter.enable()){
                connectBT()
            }else{
                Toast.makeText(this, "bluetooth is turned off", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initView(){
        humanFollowingCardView = findViewById(R.id.humanFollowingCard)
        obstacleAvoidingCardView = findViewById(R.id.obstacleAvoidingCard)
        selfDrivingCardView = findViewById(R.id.selfDrivingCard)
        bluetoothCardView = findViewById(R.id.bluetoothCard)
        constraintLayout = findViewById(R.id.constraint)
    }

    private  var resultActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
        if (result.resultCode == Activity.RESULT_OK){
            val intent = result.data
            snackBar(intent.toString())
        }

    }

    private  fun snackBar(message:String){
        Snackbar.make(constraintLayout,message,Snackbar.LENGTH_SHORT)
            .show()

    }

    private fun connectBT(){
        Common(this).checkPermission()
        bluetoothAdapter = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        if(!bluetoothAdapter.adapter.enable()){
            val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            resultActivity.launch(intent)
        }

        val bluetoothDevice = bluetoothAdapter.adapter.getRemoteDevice(DEVICE_ADDRESS)
        val uuid = bluetoothDevice.uuids[0].uuid
        var socket:BluetoothSocket? = null

        try{
            socket = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid)
        }catch (e: IOException){
            e.printStackTrace()
        }
        bluetoothSocket=socket!!
        bluetoothSocket.connect()
        if(bluetoothSocket.isConnected){
            Toast.makeText(this@MainActivity, "connected successfully", Toast.LENGTH_SHORT).show()
        }

        try{
            inputStream = bluetoothSocket.inputStream
            outputStream = bluetoothSocket.outputStream
        }catch (e:IOException){
            e.printStackTrace()
        }


    }

    companion object{
        lateinit var inputStream: InputStream
        lateinit var outputStream: OutputStream
        const val DEVICE_ADDRESS:String="00:21:13:00:2C:70"// THE BLUETOOTH MAC-ADDRESS
        const val TAG = "MainActivity"
    }

}
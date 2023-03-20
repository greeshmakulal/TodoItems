package com.simplequiz.todoitems

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver
import android.widget.Switch
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_todo.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter:TodoAdapter
//    lateinit var wifiSwitch: Switch
//    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val intent = Intent(this, Myservice::class.java)
//        btn_start.setOnClickListener {
//            startService(intent)
//        }
//        btn_stop.setOnClickListener {
////            stopService(intent)
//
//
//            CoroutineScope(IO).launch {
//                fakrequestApi()
//            }
//        }

//        wifiSwitch = findViewById(R.id.wifiSwitch)
//        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        wifiSwitch.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                wifiManager.isWifiEnabled= true
//                wifiSwitch.text = "WiFi is ON"
//            } else {
//                wifiManager.isWifiEnabled = false
//                wifiSwitch.text = "WiFi is OFF"
//            }

            todoAdapter = TodoAdapter(mutableListOf())
            rvTodoItems.adapter = todoAdapter
            rvTodoItems.layoutManager = LinearLayoutManager(this)
            btn_todo.setOnClickListener {
                val title = etTodo.text.toString()
                if (!title.isEmpty()) {
                    val todo = Todo(title)
                    todoAdapter.addTodo(todo)
                    etTodo.text.clear()
                }


            }
            btn_DeleteTodo.setOnClickListener {
                todoAdapter.deleteTodos()
            }
        }
    }
//    override fun onStart() {
//        super.onStart()
////        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
////        registerReceiver(wifiStateReceiver, intentFilter)
//    }
//    override fun onStop() {
//        super.onStop()
////        unregisterReceiver(wifiStateReceiver)
//    }
//    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            when (intent.getIntExtra(
//                WifiManager.EXTRA_WIFI_STATE,
//                WifiManager.WIFI_STATE_UNKNOWN
//            )) {
//                WifiManager.WIFI_STATE_ENABLED -> {
//                    wifiSwitch.isChecked = true
//                    wifiSwitch.text = "WiFi is ON"
//                    Toast.makeText(this@MainActivity, "Wifi is On", Toast.LENGTH_SHORT).show()
//                }
//                WifiManager.WIFI_STATE_DISABLED -> {
//                    wifiSwitch.isChecked = false
//                    wifiSwitch.text = "WiFi is OFF"
//                    Toast.makeText(this@MainActivity, "Wifi is Off", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    } }
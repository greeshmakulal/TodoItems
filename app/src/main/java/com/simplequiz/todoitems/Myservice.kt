package com.simplequiz.todoitems

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.IBinder
import android.os.strictmode.ServiceConnectionLeakedViolation
import android.util.Log

class Myservice: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        for(i in 1..10)
        {
            Thread.sleep(1000)
            Log.e("Service logs",i.toString())
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
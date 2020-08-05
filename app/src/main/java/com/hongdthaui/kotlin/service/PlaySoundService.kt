package com.hongdthaui.kotlin.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.hongdthaui.kotlin.R

/**
 * Created by hongdthaui on 7/29/2020.
 */
class PlaySoundService: Service() {
    lateinit var mp: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        //Log.e("GAME","onCreate")
        mp = MediaPlayer.create(applicationContext, R.raw.research_help)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
       // Log.e("GAME","onStartCommand")
        mp.start()
        return START_STICKY
    }

    override fun onDestroy() {
        mp.release()
        super.onDestroy()
    }
}
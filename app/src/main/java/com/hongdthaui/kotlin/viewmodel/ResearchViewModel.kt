package com.hongdthaui.kotlin.viewmodel

import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import com.hongdthaui.kotlin.R

/**
 * Created by hongdthaui on 7/24/2020.
 */
class ResearchViewModel(application: Application) :AndroidViewModel(application) {
    private var context = application.applicationContext
    var sound: ObservableInt = ObservableInt()
    var haibatrung = ObservableBoolean(false)
    fun onClickIcon(view: View, soundName: Int){
        haibatrung.set(!haibatrung.get())
        var mp = MediaPlayer.create(context,soundName)
        mp.start()
       // Log.e("L",soundName)
        val ani: Animation = AnimationUtils.loadAnimation(view.context, R.anim.bounce)
        view.startAnimation(ani)
    }
}
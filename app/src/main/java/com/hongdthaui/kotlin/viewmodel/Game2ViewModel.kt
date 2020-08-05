package com.hongdthaui.kotlin.viewmodel

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.util.ArrayMap
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.model.Game

/**
 * Created by hongdthaui on 7/24/2020.
 */
class Game2ViewModel(application: Application) : AndroidViewModel(application) {
    val NUM_ANSWER = 4
    var iconAnswer: ObservableArrayMap<Int, Int>
    var iconMain: ObservableInt
    var scoreTxt: ObservableField<String>
    var game: Game
    var arrIcAll = ArrayMap<Int,Int>()
    var nextStage = MutableLiveData<Boolean>(false)
    init {
        game = Game(NUM_ANSWER,12)

        iconMain = ObservableInt(0)
        iconAnswer = ObservableArrayMap<Int, Int>()
        scoreTxt = ObservableField(game.score.toString()+"/"+game.MAX_SCORE)
        //numElement = num arrIcAll
        arrIcAll.put(1,R.drawable.ic_anduongvuong)
        arrIcAll.put(2,R.drawable.ic_haibatrung)
        arrIcAll.put(3,R.drawable.ic_huongdaovuong)
        arrIcAll.put(4,R.drawable.ic_leloi)
        arrIcAll.put(5,R.drawable.ic_lythuongkiet)
        arrIcAll.put(6,R.drawable.ic_ngoquyen)
        arrIcAll.put(7,R.drawable.ic_quangtrung)
        arrIcAll.put(8,R.drawable.ic_sontinh)
        arrIcAll.put(9,R.drawable.ic_thanhgiong)
        arrIcAll.put(10,R.drawable.ic_thuytinh)
        arrIcAll.put(11,R.drawable.ic_tranquoctoan)
        arrIcAll.put(12,R.drawable.ic_yetkieu)

        nextStep()
    }

    fun nextStep(){
        game.nextStep()
        iconMain.set(arrIcAll.getValue(game.trueAnswer))
        for(i in 1..NUM_ANSWER){
            iconAnswer.put(i,arrIcAll[game.listAnswer[i-1]])
        }
    }

    fun onClickAnswer(view: View, answer: Int) {
        startAnim(view)
        if(game.checkAnswer(answer)){
            playSound(view.context,true)
            scoreTxt.set(game.score.toString()+"/"+game.MAX_SCORE)
            if(game.isWin()){
                //Log.e("GAME", "next Stage=")
                nextStage.value = true
            }
            else{
                nextStep()
            }
        } else {
            playSound(view.context,false)
            nextStep()
            Log.e("GAME", "false")
        }
    }

    private fun startAnim(view: View) {
        val ani: Animation = AnimationUtils.loadAnimation(view.context, R.anim.bounce)
        view.startAnimation(ani)
    }
    fun playSound(context: Context, isTrue: Boolean){
        val file = if (isTrue) R.raw.true_answer else R.raw.false_answer
        var mp  = MediaPlayer.create(context,file)
        mp.start()
    }
}
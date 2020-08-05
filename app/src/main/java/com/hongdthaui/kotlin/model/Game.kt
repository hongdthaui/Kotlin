package com.hongdthaui.kotlin.model

import android.util.Log
import com.hongdthaui.kotlin.R

/**
 * Created by hongdthaui on 7/27/2020.
 */
class Game(numAnswer: Int, numElement: Int) {
    val MAX_SCORE = 10
    var trueAnswer = 0
    val numElement = numElement
    var listAnswer = IntArray(numAnswer)
    var score = 0
    var arrForAswrTrue:MutableList<Int> = mutableListOf()
    init {
        for (i in 1..numElement){
            arrForAswrTrue.add(i)
        }
        //Log.e("GAME","arrForAswrTrue ="+arrForAswrTrue.toString())

    }

    fun nextStep() {
        if (arrForAswrTrue.size <= 0) {
            return
        }

        var arrIcAll = mutableListOf<Int>()
        for(i in 1..numElement){
            arrIcAll.add(i)
        }

        trueAnswer = arrForAswrTrue[arrForAswrTrue.indices.random()]//0..11
       // Log.e("GAME","true A="+trueAnswer)
        //Log.e("GAME","arrIcAll ="+arrIcAll.toString())
        //remove
        arrIcAll.remove(trueAnswer)

            //Log.e("GAME","arrIcAll ="+arrIcAll.toString())
        //Log.e("GAME","arrIcAll indices="+arrIcAll.indices.toString())
        val slotMain = (0..(listAnswer.size - 1)).random()
        listAnswer[slotMain] = trueAnswer

        for (i in 0..(listAnswer.size - 1)) {
            if (i == slotMain)
                continue
            else {
                listAnswer[i] = arrIcAll[(arrIcAll.indices).random()]
                arrIcAll.remove(listAnswer[i])
            }
        }
        //Log.e("Game","trueAnswer="+trueAnswer)
       // for (i in listAnswer)
        //    Log.e("Game","listAnswer i="+i)
       // Log.e("Game","------------------")
    }

    fun checkAnswer(answer: Int): Boolean {
        //Log.e("Game","listAnswer[answer]="+listAnswer[answer])
        //Log.e("Game","trueAnswer="+trueAnswer)
        if (listAnswer[answer] == trueAnswer) {
            ++score
            arrForAswrTrue.remove(trueAnswer)
            return true
        }
        return false
    }

    fun isWin(): Boolean {
        if (score >= MAX_SCORE) {
            return true
        }
        return false
    }
}
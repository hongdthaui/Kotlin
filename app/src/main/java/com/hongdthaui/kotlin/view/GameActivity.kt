package com.hongdthaui.kotlin.view

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.databinding.ActivityGameBinding
import com.hongdthaui.kotlin.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {
    private lateinit var viewModel: GameViewModel
    private lateinit var binding: ActivityGameBinding
    private lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_game)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_game
        )
        binding.viewModel = viewModel


        val adRequest = AdRequest.Builder().build()
        game_adView.loadAd(adRequest)
    }

    override fun onStart() {
        super.onStart()
        viewModel.nextStage.observe(this, Observer {
            if(it){
                intent = Intent(this,Game2Activity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

    override fun onResume() {
        if(game_adView!=null){
            game_adView.resume()
        }
        super.onResume()
        var mp = MediaPlayer.create(this,R.raw.game_help)
        mp.start()
    }
    fun onClickHome(view: View){
        onBackPressed()
    }

    override fun onPause() {
        if(game_adView!=null){
            game_adView.pause()
        }
        super.onPause()
    }

    override fun onDestroy() {
        if(game_adView!=null){
            game_adView.destroy()
        }
        super.onDestroy()
    }
}
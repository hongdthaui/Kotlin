package com.hongdthaui.kotlin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.databinding.ActivityGame2Binding
import com.hongdthaui.kotlin.viewmodel.Game2ViewModel
import kotlinx.android.synthetic.main.activity_game2.*

class Game2Activity : AppCompatActivity() {
    private lateinit var viewModel: Game2ViewModel
    private lateinit var binding: ActivityGame2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Game2ViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_game2
        )
        binding.viewModel = viewModel

        val adRequest = AdRequest.Builder().build()
        game2_adView.loadAd(adRequest)
    }

    override fun onStart() {
        super.onStart()
        viewModel.nextStage.observe(this, Observer {
            if(it){
                intent = Intent(this,Game3Activity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
    fun onClickHome(view: View){
        onBackPressed()
/*        intent = Intent(this, ResearchActivity::class.java)
        startActivity(intent)*/
    }

    override fun onResume() {
        if(game2_adView!=null){
            game2_adView.resume()
        }
        super.onResume()
    }

    override fun onPause() {
        if(game2_adView!=null){
            game2_adView.pause()
        }
        super.onPause()
    }

    override fun onDestroy() {
        if(game2_adView!=null){
            game2_adView.destroy()
        }
        super.onDestroy()
    }
}
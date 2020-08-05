package com.hongdthaui.kotlin.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.databinding.ActivityGame3Binding
import com.hongdthaui.kotlin.viewmodel.Game3ViewModel
import kotlinx.android.synthetic.main.activity_game3.*

class Game3Activity : AppCompatActivity() {
    lateinit var binding: ActivityGame3Binding
    lateinit var viewModel: Game3ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Game3ViewModel::class.java)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_game3
        )
        binding.viewModel = viewModel
        val adRequest = AdRequest.Builder().build()
        game3_adView.loadAd(adRequest)
    }

    fun onClickHome(view: View) {
        onBackPressed()
/*        intent = Intent(this, ResearchActivity::class.java)
        startActivity(intent)*/
    }

    override fun onStart() {
        super.onStart()
        viewModel.isWin.observe(this, Observer {
            if (it) {
                var listener = object : WinDialog.Listener {
                    override fun clickReplay() {
                        val intent = Intent(this@Game3Activity, GameActivity::class.java)
                        startActivity(intent)
                    }

                    override fun clickHome() {
                        val intent = Intent(this@Game3Activity, ResearchActivity::class.java)
                        startActivity(intent)
                    }

                }
                val dialog = WinDialog(this, listener)
                dialog.show()

            }
        })
    }

    override fun onResume() {
        if(game3_adView!=null){
            game3_adView.resume()
        }
        super.onResume()
    }

    override fun onPause() {
        if(game3_adView!=null){
            game3_adView.pause()
        }
        super.onPause()
    }

    override fun onDestroy() {
        if(game3_adView!=null){
            game3_adView.destroy()
        }
        super.onDestroy()
    }
}
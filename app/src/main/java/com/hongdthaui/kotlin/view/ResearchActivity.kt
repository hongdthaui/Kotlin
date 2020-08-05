package com.hongdthaui.kotlin.view

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.service.PlaySoundService
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_research.*
import kotlin.concurrent.thread

class ResearchActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_research)

        MobileAds.initialize(this)

        viewPager = findViewById(R.id.viewPager)

        var pageList: ArrayList<Research2Fragment> = arrayListOf()
        pageList.add(Research2Fragment())
        //pageList.add(Research2Fragment())
        //pageList.add(Research2Fragment())

        var adapter = PagerAdapter(
            supportFragmentManager,
            pageList
        )
        viewPager.adapter = adapter

        val adRequest = AdRequest.Builder().build()
        research_adView.loadAd(adRequest)
    }

    fun onClickPlay(view: View) {


        intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        if (research_adView != null) {
            research_adView.resume()
        }
        super.onResume()
/*        thread() {
            var mp = MediaPlayer.create(
                baseContext,
                R.raw.game_help
            )
            mp.start()
        }*/
        var intent = Intent(this,PlaySoundService::class.java)
        startService(intent)
    }

    override fun onPause() {
        if (research_adView != null) {
            research_adView.pause()
        }
        super.onPause()
    }

    override fun onDestroy() {
        if (research_adView != null) {
            research_adView.destroy()
        }
        super.onDestroy()
    }

}
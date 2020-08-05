package com.hongdthaui.kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongdthaui.kotlin.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var pageList: ArrayList<DetailFragment> = arrayListOf()
        pageList.add(DetailFragment())
        pageList.add(DetailFragment())
        //pageList.add(Research2Fragment())

        var adapter = DetailPagerAdapter(
            supportFragmentManager,
            pageList
        )
        detail_viewPager.adapter = adapter
    }
}
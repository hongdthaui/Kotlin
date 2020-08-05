package com.hongdthaui.kotlin.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by hongdthaui on 7/31/2020.
 */
class DetailPagerAdapter(fm: FragmentManager, private var pagers: ArrayList<DetailFragment>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return pagers[position]
    }

    override fun getCount(): Int {
        return pagers.size
    }
}
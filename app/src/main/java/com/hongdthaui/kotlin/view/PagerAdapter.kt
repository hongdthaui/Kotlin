package com.hongdthaui.kotlin.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by hongdthaui on 7/23/2020.
 */
class PagerAdapter(fm:FragmentManager, private val pagers:ArrayList<Research2Fragment>):FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return pagers[position]
    }

    override fun getCount(): Int {
        return pagers.size;
    }
}
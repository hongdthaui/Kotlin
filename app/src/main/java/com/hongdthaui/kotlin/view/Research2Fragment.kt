package com.hongdthaui.kotlin.view

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.databinding.FragmentResearch2Binding
import com.hongdthaui.kotlin.viewmodel.ResearchViewModel

/**
 * Created by hongdthaui on 7/23/2020.
 */
class Research2Fragment: Fragment() {
    private lateinit var viewModel: ResearchViewModel
    private lateinit var binding: FragmentResearch2Binding
    init {

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity?:this).get(ResearchViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_research_2,container,false)
        binding.viewModel = viewModel
        return binding.root//inflater.inflate(R.layout.fragment_research_2,container,false)
    }
}
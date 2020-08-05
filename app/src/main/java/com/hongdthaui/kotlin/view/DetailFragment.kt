package com.hongdthaui.kotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.databinding.FragmentDetailBinding
import com.hongdthaui.kotlin.viewmodel.DetailViewModel

/**
 * Created by hongdthaui on 7/31/2020.
 */
class DetailFragment: Fragment() {
    lateinit var viewModel: DetailViewModel
    lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false)
        binding.viewModel = viewModel
        return binding.root
    }
}
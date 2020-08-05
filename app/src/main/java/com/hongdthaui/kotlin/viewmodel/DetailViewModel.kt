package com.hongdthaui.kotlin.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel

/**
 * Created by hongdthaui on 7/31/2020.
 */
class DetailViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var name: ObservableField<String>
    lateinit var since: ObservableField<String>
    lateinit var banner: ObservableInt
    lateinit var detail: ObservableField<String>
}
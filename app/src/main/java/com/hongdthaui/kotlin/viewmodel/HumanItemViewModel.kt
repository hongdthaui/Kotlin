package com.hongdthaui.kotlin.viewmodel

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.hongdthaui.kotlin.model.Human

/**
 * Created by hongdthaui on 7/23/2020.
 */
class HumanItemViewModel(human: Human) {
    var name: ObservableField<String>
    var icon: ObservableInt
    init {
        name = ObservableField(human.Name)
        icon = ObservableInt(human.Icon)
    }
}
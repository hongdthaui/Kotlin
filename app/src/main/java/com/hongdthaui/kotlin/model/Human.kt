package com.hongdthaui.kotlin.model

import android.graphics.drawable.Icon

/**
 * Created by hongdthaui on 7/23/2020.
 */
class Human(name:String, icon: Int, sound: Int) {
    private var name: String= name
    private var icon: Int = icon
    private var sound: Int = sound
    var Name: String
        get() {
            return name
        }
        set(value) {
            name = value
        }

    var Icon: Int
    get() {
        return icon
    }
    set(value) {
        icon=value
    }

    var Sound: Int
    get() {
        return sound
    }
    set(value) {
        sound=value
    }
}
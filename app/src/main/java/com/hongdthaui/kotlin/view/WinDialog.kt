package com.hongdthaui.kotlin.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.hongdthaui.kotlin.R
import kotlinx.android.synthetic.main.dialog_win.*

/**
 * Created by hongdthaui on 7/28/2020.
 */
class WinDialog(context: Context, listener: WinDialog.Listener) : Dialog(context) {
    interface Listener{
        fun clickReplay()
        fun clickHome()
    }
    var listener: WinDialog.Listener = listener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_win)
        win_bt_home.setOnClickListener {
            dismiss()
            listener.clickHome()
        }
        win_bt_replay.setOnClickListener {
            dismiss()
            listener.clickReplay()
        }
    }
}
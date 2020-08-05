package com.hongdthaui.kotlin.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hongdthaui.kotlin.R
import com.hongdthaui.kotlin.databinding.ItemHumanBinding
import com.hongdthaui.kotlin.model.Human
import com.hongdthaui.kotlin.viewmodel.HumanItemViewModel

/**
 * Created by hongdthaui on 7/23/2020.
 */
class HumanAdapter(listHuman: ArrayList<Human>): RecyclerView.Adapter<HumanAdapter.HumanHolder>() {
    private var listHuman: ArrayList<Human> = arrayListOf()
    init {
        this.listHuman = listHuman
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanHolder {
        var itemBinding: ItemHumanBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_human,parent,false)
        return HumanHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return listHuman.size
    }

    override fun onBindViewHolder(holder: HumanHolder, position: Int) {
        var human: Human = listHuman.get(position)
        holder.itemBinding.viewModel = HumanItemViewModel(human)
    }

    class HumanHolder(item: ItemHumanBinding) : RecyclerView.ViewHolder(item.root){
        var itemBinding: ItemHumanBinding = item
    }
}
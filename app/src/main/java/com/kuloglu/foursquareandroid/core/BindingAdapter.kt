package com.kuloglu.foursquareandroid.core

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:set_list")
    fun setList(recyclerView: RecyclerView, list: List<Nothing>?) {
        val adapter = recyclerView.adapter as BaseAdapter<*>
        list?.let {
            adapter.submitList(null)
            adapter.submitList(list)
        }
    }

}
package com.kuloglu.foursquareandroid.core

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.kuloglu.foursquareandroid.R
import com.squareup.picasso.Picasso

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

    @JvmStatic
    @BindingAdapter("app:set_map")
    fun setMap(imageView: ImageView, ll: String) {
        if (ll.isNotEmpty()) {
            val link = "https://maps.googleapis.com/maps/api/staticmap?center=$ll&zoom=17&size=600x480&markers=color:red%7C$ll"
            Picasso.get().load(link).placeholder(R.color.white).resize(600, 480).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:set_src")
    fun setSrc(imageView: ImageView, path: String) {
        if (path.isNotEmpty()) {
            Picasso.get().load(path).into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("app:visibility")
    fun setVisibilty(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}
package com.kuloglu.foursquareandroid.ui.venueList

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.core.BaseAdapter
import com.kuloglu.foursquareandroid.databinding.ItemPlaceBinding
import com.kuloglu.foursquareandroid.db.entities.foursquare.Venue

class VenueListAdapter(private val clickCallback: ((Venue) -> Unit)?) : BaseAdapter<Venue>(object : DiffUtil.ItemCallback<Venue>() {
    override fun areItemsTheSame(oldItem: Venue?, newItem: Venue?): Boolean {
        return oldItem?.name == newItem?.name
    }

    override fun areContentsTheSame(oldItem: Venue?, newItem: Venue?): Boolean {
        return oldItem == newItem
    }

}) {


    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val viewModel = VenueItemViewModel(parent.context.applicationContext as App)
        val binding = DataBindingUtil.inflate<ItemPlaceBinding>(LayoutInflater.from(parent.context), R.layout.item_place, parent, false)
        binding.viewModel = viewModel
        binding.root.setOnClickListener {
            binding.viewModel?.let { clickCallback?.invoke(it.venue) }
        }

        return binding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemPlaceBinding).viewModel?.setItem(getItem(position))
        binding.executePendingBindings()
    }

}
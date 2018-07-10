package com.kuloglu.foursquareandroid.ui.venueList.dialogFragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.core.BaseAdapter
import com.kuloglu.foursquareandroid.core.FourSquare
import com.kuloglu.foursquareandroid.databinding.ItemDialogMapBinding
import com.kuloglu.foursquareandroid.databinding.ItemDialogPictureBinding
import com.kuloglu.foursquareandroid.databinding.ItemDialogTipBinding
import com.kuloglu.foursquareandroid.db.entities.DialogFragmentItem

class DialogFragmentAdapter : BaseAdapter<DialogFragmentItem>(object : DiffUtil.ItemCallback<DialogFragmentItem>() {
    override fun areItemsTheSame(oldItem: DialogFragmentItem?, newItem: DialogFragmentItem?): Boolean {
        return oldItem?.type == newItem?.type
    }

    override fun areContentsTheSame(oldItem: DialogFragmentItem?, newItem: DialogFragmentItem?): Boolean {
        return oldItem == newItem
    }

}) {

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val viewModel = DialogFragmentItemViewModel(parent.context.applicationContext as App)
        when (viewType) {
            FourSquare.TIP -> {
                val binding = DataBindingUtil.inflate<ItemDialogTipBinding>(LayoutInflater.from(parent.context), R.layout.item_dialog_tip, parent, false)
                binding.viewModel = viewModel
                return binding

            }
            FourSquare.PHOTO -> {
                val binding = DataBindingUtil.inflate<ItemDialogPictureBinding>(LayoutInflater.from(parent.context), R.layout.item_dialog_picture, parent, false)
                binding.viewModel = viewModel
                return binding

            }
            else -> {
                val binding = DataBindingUtil.inflate<ItemDialogMapBinding>(LayoutInflater.from(parent.context), R.layout.item_dialog_map, parent, false)
                binding.viewModel = viewModel
                return binding
            }
        }
    }

    override fun bind(binding: ViewDataBinding, position: Int) {

        when (getItem(position).type) {
            FourSquare.TIP -> (binding as ItemDialogTipBinding).viewModel?.setItem(getItem(position))
            FourSquare.PHOTO -> (binding as ItemDialogPictureBinding).viewModel?.setItem(getItem(position))
            FourSquare.MAP -> (binding as ItemDialogMapBinding).viewModel?.setItem(getItem(position))
        }

    }
}
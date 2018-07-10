package com.kuloglu.foursquareandroid.ui.venueList.dialogFragment

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.databinding.FragmentDialogBinding


class DialogListFragment : DialogFragment(), LifecycleOwner {
    var id = ""
    var header = ""
    var ll = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        id = arguments?.getString("id", "").toString()
        header = arguments?.getString("header", "").toString()
        ll = arguments?.getString("ll", "").toString()

    }


    lateinit var binding: FragmentDialogBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.viewModel = ViewModelProviders.of(this).get(DialogFragmentViewModel::class.java)
        binding.viewModel?.create(id, header, ll)
        binding.recyclerView.adapter = DialogFragmentAdapter()
        binding.root.setOnClickListener {
            dismiss()
        }
        return binding.root
    }


    fun getLayoutRes() = R.layout.fragment_dialog

    companion object {
        fun newInstance(id: String, header: String, ll: String): DialogFragment {
            val fragment = DialogListFragment()
            val args = Bundle()
            args.putString("id", id)
            args.putString("header", header)
            args.putString("ll", ll)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)

    }

}
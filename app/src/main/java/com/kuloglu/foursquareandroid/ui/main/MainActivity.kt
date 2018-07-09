package com.kuloglu.foursquareandroid.ui.main

import android.content.Intent
import android.os.Bundle
import com.foursquare.android.nativeoauth.FoursquareOAuth
import com.foursquare.android.nativeoauth.model.AccessTokenResponse
import com.foursquare.android.nativeoauth.model.AuthCodeResponse
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.core.BaseActivity
import com.kuloglu.foursquareandroid.core.FourSquare
import com.kuloglu.foursquareandroid.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(mainToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        }

    }


    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }



    override fun getLayoutRes() = R.layout.activity_main
}

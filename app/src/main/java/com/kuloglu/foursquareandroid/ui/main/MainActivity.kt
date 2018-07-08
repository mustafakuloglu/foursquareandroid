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

    private val REQUEST_CODE_FSQ_CONNECT = 1111
    private val REQUEST_CODE_FSQ_TOKEN_EXCHANGE = 2222
    private lateinit var codeResponse: AuthCodeResponse
    private lateinit var tokenResponse: AccessTokenResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(mainToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        }
        val intent = FoursquareOAuth.getConnectIntent(this, FourSquare.CLIENT_ID)
        startActivityForResult(intent, REQUEST_CODE_FSQ_CONNECT)

    }


    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        when (requestCode) {
            REQUEST_CODE_FSQ_CONNECT -> {
                codeResponse = FoursquareOAuth.getAuthCodeFromResult(resultCode, data)
                val intent = FoursquareOAuth.getTokenExchangeIntent(this, FourSquare.CLIENT_ID, FourSquare.CLIENT_SECRET, codeResponse.code)
                startActivityForResult(intent, REQUEST_CODE_FSQ_TOKEN_EXCHANGE)
            }
            REQUEST_CODE_FSQ_TOKEN_EXCHANGE -> {
                tokenResponse = FoursquareOAuth.getTokenFromResult(resultCode, data)
            }
        }

    }

    override fun getLayoutRes() = R.layout.activity_main
}

package com.kuloglu.foursquareandroid.ui.venueList

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.MenuItem
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.core.BaseActivity
import com.kuloglu.foursquareandroid.databinding.ActivityVenueListBinding
import kotlinx.android.synthetic.main.activity_venue_list.*
import org.jetbrains.anko.toast


class VenueListActivity : BaseActivity<VenueListActivityViewModel, ActivityVenueListBinding>(VenueListActivityViewModel::class.java) {
    private val REQ_CODE = 111
    var type = ""
    override fun initViewModel(viewModel: VenueListActivityViewModel) {
        binding.viewModel=viewModel
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = VenueListAdapter()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setSupportActionBar(listToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
        }
        val location = intent.getStringExtra("location")
        type = intent.getStringExtra("type")
        if(location.isNotEmpty())
            binding.viewModel?.connectWithCustomLocation(location,type)
        else
            startWithCurrentLocation()



    }

    private fun startWithCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),REQ_CODE)
        }
        else
        fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if(location!=null)
                        binding.viewModel?.connectWithCurrentLocation(type,location.latitude,location.longitude)
                    else
                    {
                        toast(getString(R.string.location_cannot_find))
                        finish()
                    }
                }
    }

    override fun getLayoutRes() = R.layout.activity_venue_list


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        super.onOptionsItemSelected(item)
        when(item?.itemId)
        {
            android.R.id.home -> finish()
        }

        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQ_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    startWithCurrentLocation()
                } else {
                    toast(getString(R.string.location_message))
                    finish()
                }
                return
            }


            else -> {
            }
        }
    }
}

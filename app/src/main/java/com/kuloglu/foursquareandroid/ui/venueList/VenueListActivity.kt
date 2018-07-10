package com.kuloglu.foursquareandroid.ui.venueList

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.view.MenuItem
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.location.*
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.core.BaseActivity
import com.kuloglu.foursquareandroid.databinding.ActivityVenueListBinding
import com.kuloglu.foursquareandroid.db.entities.foursquare.Venue
import com.kuloglu.foursquareandroid.ui.venueList.dialogFragment.DialogListFragment
import org.jetbrains.anko.toast


class VenueListActivity : BaseActivity<VenueListActivityViewModel, ActivityVenueListBinding>(VenueListActivityViewModel::class.java), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    override fun onLocationChanged(p0: Location?) {
        mLastLocation = p0
        startWithCurrentLocation()
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
    }

    override fun onConnected(p0: Bundle?) {
        mLocationRequest = createLocationRequest()
        builder = LocationSettingsRequest.Builder().addLocationRequest(mLocationRequest as LocationRequest)
        result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder?.build())
        result?.setResultCallback { result ->
            val status = result.status
            when (status.statusCode) {
                LocationSettingsStatusCodes.SUCCESS ->
                    if (ActivityCompat.checkSelfPermission(this@VenueListActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this@VenueListActivity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this@VenueListActivity, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION)
                    } else {
                        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient)
                        if (mLastLocation == null)
                            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this@VenueListActivity);
                        else
                            startWithCurrentLocation()
                    }
                LocationSettingsStatusCodes.RESOLUTION_REQUIRED ->
                    try {
                        status.startResolutionForResult(this@VenueListActivity, REQUEST_CHECK_SETTINGS)
                    } catch (e: IntentSender.SendIntentException) {
                    }

                LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                }

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        recreate()
    }

    override fun onConnectionSuspended(p0: Int) {
    }

    lateinit var mGoogleApiClient: GoogleApiClient
    private var mLastLocation: Location? = null
    private val REQUEST_LOCATION = 200
    private val REQUEST_CHECK_SETTINGS = 300
    private var builder: LocationSettingsRequest.Builder? = null
    private var result: PendingResult<LocationSettingsResult>? = null
    private var mLocationRequest: LocationRequest? = null
    private val REQ_CODE = 111
    var type = ""
    override fun initViewModel(viewModel: VenueListActivityViewModel) {
        binding.viewModel=viewModel
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var location: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = VenueListAdapter({
            showDialog(it)

        })

        setSupportActionBar(binding.listToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
        }
        location = intent.getStringExtra("location")
        type = intent.getStringExtra("type")
        if(location.isNotEmpty())
            binding.viewModel?.connectWithCustomLocation(location,type)
        else {
            mGoogleApiClient = GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build()


        }


    }

    override fun onStart() {
        super.onStart()
        if (location.isEmpty())
            mGoogleApiClient.connect()
    }

    private fun startWithCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),REQ_CODE)
        }
        else {
            if (mLastLocation != null)
                binding.viewModel?.connectWithCurrentLocation(type, mLastLocation!!.latitude, mLastLocation!!.longitude)
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
            REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    recreate()
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

    fun createLocationRequest(): LocationRequest {
        val mLocationRequest = LocationRequest()
        mLocationRequest.interval = 10000
        mLocationRequest.fastestInterval = 5000
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        return mLocationRequest
    }

    fun showDialog(venue: Venue) {
        val fm = supportFragmentManager

        val fragment = DialogListFragment.newInstance(venue.id, venue.name, venue.location.lat.toString() + "," + venue.location.lng.toString())
        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog)
        fragment.isCancelable = true
        fragment.show(fm, "dialog")
    }

}

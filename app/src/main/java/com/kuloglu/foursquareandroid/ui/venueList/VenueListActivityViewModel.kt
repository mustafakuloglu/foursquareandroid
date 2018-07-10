package com.kuloglu.foursquareandroid.ui.venueList

import android.app.Application
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.db.entities.foursquare.Venue
import com.kuloglu.foursquareandroid.service.VenueService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class VenueListActivityViewModel(app:Application): BaseViewModel(app) {
    private val compositeDisposable = CompositeDisposable()
    val venueList: ObservableList<Venue> = ObservableArrayList()


    @Inject
    lateinit var api:VenueService

    init {
        getApplication<App>().component.inject(this)
    }



     fun connectWithCurrentLocation(type: String, latitude: Double, longitude: Double) {

         val cacheList = arrayListOf<Venue>()
         val ll= latitude.toString()+","+longitude.toString()
         compositeDisposable.add(api.getVenueCurrentLocation(type, ll).subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread()).onErrorReturn {
                     val asd =it.localizedMessage
                     null
                 }
                 .subscribe {
                     cacheList.clear()
                     it.response?.groups?.forEach { group ->
                         group?.items?.forEach {
                             cacheList.add(it.venue)
                         }
                     }
                     venueList.clear()
                     venueList.addAll(cacheList)
                 })


     }

     fun connectWithCustomLocation(type:String,location:String){

         val cacheList = arrayListOf<Venue>()
        compositeDisposable.add(api.getVenue(type, location).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).onErrorReturn {
                    val asd =it.localizedMessage
                    null
                }
                .subscribe {
                    cacheList.clear()
                    it.response?.groups?.forEach { group ->
                        group?.items?.forEach {
                            cacheList.add(it.venue)
                        }
                    }
                    venueList.clear()
                    venueList.addAll(cacheList)
                })

    }


}
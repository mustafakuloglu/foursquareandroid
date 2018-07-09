package com.kuloglu.foursquareandroid.ui.venueList

import android.app.Application
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.db.entities.VenueItem
import com.kuloglu.foursquareandroid.service.VenueService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class VenueListActivityViewModel(app:Application): BaseViewModel(app) {
    private val compositeDisposable = CompositeDisposable()
    val venueList: ObservableList<VenueItem> = ObservableArrayList()


    @Inject
    lateinit var api:VenueService

    init {
        getApplication<App>().component.inject(this)
    }



     fun connectWithCurrentLocation(type: String, latitude: Double, longitude: Double) {

         val cacheList = arrayListOf<VenueItem>()
         val ll= latitude.toString()+","+longitude.toString()
         compositeDisposable.add(api.getVenueCurrentLocation(type, ll).subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread()).onErrorReturn {
                     val asd =it.localizedMessage
                     null
                 }
                 .subscribe {
                     cacheList.clear()
                     it.response?.groups?.forEach {
                         it?.items?.forEach {


                             val venue = VenueItem(",","","","")
                             venue.name= it?.venue?.name.toString()
                             venue.country = it?.venue?.location?.country.toString()
                             it?.venue?.location?.address?.let { address -> venue.address = address }

                             it?.venue?.location?.city?.let { venue.city=it }
                             cacheList.add(venue)

                         }
                     }
                     venueList.clear()
                     venueList.addAll(cacheList)
                 })


     }

     fun connectWithCustomLocation(type:String,location:String){

        val cacheList = arrayListOf<VenueItem>()
        compositeDisposable.add(api.getVenue(type, location).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).onErrorReturn {
                    val asd =it.localizedMessage
                    null
                }
                .subscribe {
                    cacheList.clear()
                    it.response?.groups?.forEach {
                        it?.items?.forEach {


                            val venue = VenueItem(",","","","")
                            venue.name= it?.venue?.name.toString()
                            venue.country = it?.venue?.location?.country.toString()
                            it?.venue?.location?.address?.let { address -> venue.address = address }

                            it?.venue?.location?.city?.let { venue.city=it }
                            cacheList.add(venue)

                        }
                    }
                    venueList.clear()
                    venueList.addAll(cacheList)
                })

    }


}
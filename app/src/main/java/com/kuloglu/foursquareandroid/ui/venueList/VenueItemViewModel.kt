package com.kuloglu.foursquareandroid.ui.venueList

import android.app.Application
import android.databinding.ObservableField
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.db.entities.foursquare.Venue

class VenueItemViewModel(app: Application) : BaseViewModel(app){
    val name: ObservableField<String> = ObservableField()
    val address: ObservableField<String> = ObservableField()
    val city: ObservableField<String> = ObservableField()
    val country: ObservableField<String> = ObservableField()

    lateinit var venue: Venue


    fun setItem(item: Venue) {

        venue = item

        name.set(item.name)
        if (item.location.address != null)
            address.set(item.location.address)
        if (item.location.country != null)
            country.set(item.location.country)
        if (item.location.city != null)
            city.set(item.location.city)
    }

    fun click(){}
}
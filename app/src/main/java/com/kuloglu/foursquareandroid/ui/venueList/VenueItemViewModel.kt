package com.kuloglu.foursquareandroid.ui.venueList

import android.app.Application
import android.databinding.ObservableField
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.db.entities.VenueItem

class VenueItemViewModel(app: Application) : BaseViewModel(app){
    val name: ObservableField<String> = ObservableField()
    val address: ObservableField<String> = ObservableField()
    val city: ObservableField<String> = ObservableField()
    val country: ObservableField<String> = ObservableField()


    fun setItem(item: VenueItem) {
        name.set(item.name)
        address.set(item.address)
        country.set(item.country)
        city.set(item.city)
    }

    fun click(){}
}
package com.kuloglu.foursquareandroid.ui.main

import android.app.Application
import android.content.Intent
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
import com.kuloglu.foursquareandroid.db.AppDatabase
import com.kuloglu.foursquareandroid.R
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.db.entities.VenueItem
import com.kuloglu.foursquareandroid.ui.venueList.VenueListActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivityViewModel(app: Application) : BaseViewModel(app) {

    @Inject
    lateinit var db: AppDatabase

    val type :ObservableField<String> = ObservableField("")
    val location :ObservableField<String> = ObservableField("")

    init {
        (app as? App)?.component?.inject(this)
    }


    fun  click() {
        if (type.get()?.length!! < 3)
            getApplication<App>().toast(getApplication<Application>().getString(R.string.min_character_alert))
        else {
            val intent = Intent(getApplication(), VenueListActivity::class.java)
            intent.putExtra("type", type.get())
            intent.putExtra("location", location.get())
            getApplication<App>().startActivity(intent)
        }
    }

}
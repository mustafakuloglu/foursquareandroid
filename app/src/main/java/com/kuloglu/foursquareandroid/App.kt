package com.kuloglu.foursquareandroid

import com.kuloglu.foursquareandroid.di.component.DaggerApplicationComponent
import com.kuloglu.foursquareandroid.di.module.ApplicationModule

class App : android.app.Application() {

    val component by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}


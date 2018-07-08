package com.kuloglu.foursquareandroid.di.component

import android.content.Context
import android.content.SharedPreferences
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.di.module.ApplicationModule
import com.kuloglu.foursquareandroid.di.module.DatabaseModule
import com.kuloglu.foursquareandroid.ui.main.MainActivityViewModel

import com.kuloglu.foursquareandroid.di.module.NetModule

import dagger.Component
import javax.inject.Singleton


@Singleton

@Component(modules = arrayOf(ApplicationModule::class,NetModule::class,DatabaseModule::class))


interface ApplicationComponent {
    fun app(): App


    fun context(): Context

    fun preferences(): SharedPreferences

    fun inject(mainActivityViewModel: MainActivityViewModel)
}

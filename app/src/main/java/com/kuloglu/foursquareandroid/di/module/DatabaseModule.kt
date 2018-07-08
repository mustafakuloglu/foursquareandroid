package com.kuloglu.foursquareandroid.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.kuloglu.foursquareandroid.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context,
                AppDatabase::class.java, "example-db").build()
    }

}
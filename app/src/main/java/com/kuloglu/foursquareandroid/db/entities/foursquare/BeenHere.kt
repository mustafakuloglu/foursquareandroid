package com.kuloglu.foursquareandroid.db.entities.foursquare

data class BeenHere(
        val marked: Boolean? = null,
        val count: Int? = null,
        val lastCheckinExpiredAt: Int? = null,
        val unconfirmedCount: Int? = null
)

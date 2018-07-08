package com.kuloglu.foursquareandroid.db.entities.foursquare

data class Venue(
        val hereNow: HereNow? = null,
        val stats: Stats? = null,
        val contact: Contact? = null,
        val name: String? = null,
        val verified: Boolean? = null,
        val location: Location? = null,
        val id: String? = null,
        val categories: List<CategoriesItem?>? = null,
        val photos: Photos? = null,
        val beenHere: BeenHere? = null,
        val venuePage: VenuePage? = null
)

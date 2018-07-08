package com.kuloglu.foursquareandroid.db.entities.foursquare

data class Response(
        val suggestedFilters: SuggestedFilters? = null,
        val totalResults: Int? = null,
        val geocode: Geocode? = null,
        val headerFullLocation: String? = null,
        val headerLocationGranularity: String? = null,
        val groups: List<GroupsItem?>? = null,
        val suggestedBounds: SuggestedBounds? = null,
        val headerLocation: String? = null
)

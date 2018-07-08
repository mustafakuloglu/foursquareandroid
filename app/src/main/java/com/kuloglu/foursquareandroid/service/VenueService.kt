package com.kuloglu.foursquareandroid.service

import com.kuloglu.foursquareandroid.core.FourSquare
import com.kuloglu.foursquareandroid.db.entities.foursquare.FourSquareResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface VenueService {

    @GET("venues/explore?client_id=${FourSquare.CLIENT_ID},client_secret=${FourSquare.CLIENT_SECRET},v=20180323,limit=100")
    fun getVenue(@Query("section") type: String, @Query("near") location: String): Observable<FourSquareResponse>
}
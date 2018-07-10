package com.kuloglu.foursquareandroid.service

import com.kuloglu.foursquareandroid.core.FourSquare
import com.kuloglu.foursquareandroid.db.entities.foursquare.FourSquareResult
import com.kuloglu.foursquareandroid.db.entities.photo.PhotoResponse
import com.kuloglu.foursquareandroid.db.entities.tips.TipResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface VenueService {

    @GET("venues/explore?client_id=${FourSquare.CLIENT_ID}&client_secret=${FourSquare.CLIENT_SECRET}&v=20180323&limit=100")
    fun getVenue(@Query("query") type: String, @Query("near") location: String): Observable<FourSquareResult>

    @GET("venues/explore?client_id=${FourSquare.CLIENT_ID}&client_secret=${FourSquare.CLIENT_SECRET}&v=20180323&limit=100")
    fun getVenueCurrentLocation(@Query("query") type: String, @Query("ll") location: String): Observable<FourSquareResult>

    @GET("venues/{venueId}/tips?client_id=RMGPUOON505FAXPPDDV5QEKRWFKFKD1EES0XVLBWA50DSRN1&client_secret=NE5LPMC55KXDMGMJDSP45NZNMZMAETQURDGBAMSO100XMM04&v=20180323&limit=20")
    fun getVenueTips(@Path("venueId") venuId: String): Observable<TipResponse>

    @GET("venues/{venueId}/photos?client_id=RMGPUOON505FAXPPDDV5QEKRWFKFKD1EES0XVLBWA50DSRN1&client_secret=NE5LPMC55KXDMGMJDSP45NZNMZMAETQURDGBAMSO100XMM04&v=20180323&group=venue&limit=1")
    fun getPhoto(@Path("venueId") venuId: String): Observable<PhotoResponse>
}
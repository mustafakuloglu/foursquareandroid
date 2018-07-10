package com.kuloglu.foursquareandroid.ui.venueList.dialogFragment

import android.app.Application
import android.databinding.ObservableField
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.core.FourSquare
import com.kuloglu.foursquareandroid.db.entities.DialogFragmentItem
import com.kuloglu.foursquareandroid.db.entities.photo.PhotoResponse
import com.kuloglu.foursquareandroid.db.entities.tips.Items

class DialogFragmentItemViewModel(application: Application) : BaseViewModel(application) {

    val map: ObservableField<String> = ObservableField("")
    val src: ObservableField<String> = ObservableField("")
    val header: ObservableField<String> = ObservableField("")
    val tip: ObservableField<String> = ObservableField("")


    fun setItem(item: DialogFragmentItem) {
        when (item.type) {
            FourSquare.MAP -> setMap(item.ll)
            FourSquare.PHOTO -> item.name?.let { setPhoto(item.photoResponse, it) }
            FourSquare.TIP -> setMap(item.tipResponse)
        }
    }

    private fun setMap(tipResponse: Items?) {
        tipResponse?.let { tip.set(it.text) }


    }

    private fun setPhoto(photoResponse: PhotoResponse?, header: String) {
        if (photoResponse != null && photoResponse.response.photos.count > 0) {
            val url = photoResponse.response?.photos?.items?.get(0)?.prefix + "600x600" + photoResponse.response?.photos?.items?.get(0)?.suffix
            src.set(url)
        }
        this.header.set(header)

    }

    private fun setMap(ll: String?) {
        map.set(ll)
    }

}
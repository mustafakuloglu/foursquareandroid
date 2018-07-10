package com.kuloglu.foursquareandroid.ui.venueList.dialogFragment

import android.app.Application
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import com.kuloglu.foursquareandroid.App
import com.kuloglu.foursquareandroid.core.BaseViewModel
import com.kuloglu.foursquareandroid.core.FourSquare
import com.kuloglu.foursquareandroid.db.entities.DialogFragmentItem
import com.kuloglu.foursquareandroid.db.entities.photo.PhotoResponse
import com.kuloglu.foursquareandroid.db.entities.tips.TipResponse
import com.kuloglu.foursquareandroid.service.VenueService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject


class DialogFragmentViewModel(app: Application) : BaseViewModel(app) {
    private val compositeDisposable = CompositeDisposable()
    @Inject
    lateinit var api: VenueService
    lateinit var photoResponse: PhotoResponse
    lateinit var tipResponse: TipResponse

    var exec = Executors.newSingleThreadExecutor()
    var singleThreaded = Schedulers.from(exec)

    val itemList = arrayListOf<DialogFragmentItem>()
    val recycleList: ObservableList<DialogFragmentItem> = ObservableArrayList()

    init {
        (app as? App)?.component?.inject(this)
    }

    fun create(id: String, header: String, ll: String) {
        recycleList.clear()
        itemList.add(DialogFragmentItem(null, null, null, ll, FourSquare.MAP))
        getPhotoResponse(id, header)
        getTipResponse(id)
    }

    fun getPhotoResponse(id: String, header: String) {
        compositeDisposable.add(api.getPhoto(id).subscribeOn(singleThreaded)
                .observeOn(AndroidSchedulers.mainThread()).onErrorReturn {
                    val asd = it.localizedMessage
                    null
                }
                .subscribe {
                    itemList.add(DialogFragmentItem(it, null, header, null, FourSquare.PHOTO))
                    photoResponse = it

                })

    }

    fun getTipResponse(id: String) {
        compositeDisposable.add(api.getVenueTips(id).subscribeOn(singleThreaded)
                .observeOn(AndroidSchedulers.mainThread()).onErrorReturn {
                    val asd = it.localizedMessage
                    null
                }
                .subscribe {
                    tipResponse = it
                    it.response.tips.items.forEach { response ->
                        itemList.add(DialogFragmentItem(null, response, null, null, FourSquare.TIP))
                    }
                    recycleList.addAll(itemList)
                })

    }

}
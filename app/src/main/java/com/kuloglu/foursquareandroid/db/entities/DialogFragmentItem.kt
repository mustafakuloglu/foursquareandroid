package com.kuloglu.foursquareandroid.db.entities

import com.kuloglu.foursquareandroid.db.entities.photo.PhotoResponse
import com.kuloglu.foursquareandroid.db.entities.tips.Items

data class DialogFragmentItem(
        val photoResponse: PhotoResponse?,
        val tipResponse: Items?,
        val name: String?,
        val ll: String?,
        val type: Int
)
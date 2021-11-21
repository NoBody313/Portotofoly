package com.example.pototofoly.data.android

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Android(
    val id: Int = 0,
    var title: String = "",
    var poster: Int = 0,
    var link: String = ""
) : Parcelable

package com.example.trymovedata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data (
    val nim: String = "",
    val name: String = "",
    val major: String = "",
    val address: String = "",
    val dob: String = "",
    val gender: String = ""
) : Parcelable
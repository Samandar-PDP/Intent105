package com.sdk.intents.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Footballer(
    val name: String,
    val number: Int,
    val clubName: String
): Parcelable
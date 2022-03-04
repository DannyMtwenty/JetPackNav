package com.example.jetpacknav

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize     //to allow to pass arg through the bundle
data class Money(val amount : BigDecimal) : Parcelable {
}
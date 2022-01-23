package com.example.firstprojectIchaiChtitski

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
class NutritionInfo(val fat:Double,val saturatedFattyAcid:Double,val sugar: Double, val salt: Double )
:Parcelable
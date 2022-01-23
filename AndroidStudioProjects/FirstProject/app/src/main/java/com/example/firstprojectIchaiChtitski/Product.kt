package com.example.firstprojectIchaiChtitski

import Domain.Pays
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    val nom: String, val marque: String, val codeBarre: Int,
    val nutriscore: String, val urlImage: Int, val quantité: String,
    val pays: List<Pays>, val ingredients: List<String>, val allergicSubstances: List<String>,
    val additifSubstances: List<String>, val kCalories: Int,val sold: Int,val nutritionInfo: NutritionInfo
):Parcelable
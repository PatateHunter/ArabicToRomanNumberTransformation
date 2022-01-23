package com.example.firstprojectIchaiChtitski

import android.R.attr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.R.attr.button
import android.graphics.Color

import android.graphics.drawable.Drawable
import android.widget.ImageView


class ProductDetailsNutritionFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_nutrition,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = ProductDetailsFragmentArgs.fromBundle(
            requireParentFragment().requireParentFragment().requireArguments()
        ).product

        view.findViewById<TextView>(R.id.product_fat).text =  getString(R.string.product_fat,product.nutritionInfo.fat.toString())
        view.findViewById<TextView>(R.id.product_saturated_fatty_acids).text = getString(R.string.product_saturated_fatty_acids, product.nutritionInfo.saturatedFattyAcid.toString())


        view.findViewById<TextView>(R.id.product_sugars).text = getString(R.string.product_sugar, product.nutritionInfo.sugar.toString())
        view.findViewById<TextView>(R.id.product_salt).text = getString(R.string.product_salt, product.nutritionInfo.salt.toString())

        SetNutritionsImages(view,product)

    }



    fun SetNutritionsImages(view: View,product:Product){

        val nutritionInfo = product.nutritionInfo;

        if(nutritionInfo.fat >4 && nutritionInfo.fat <= 10)
            view.findViewById<ImageView>(R.id.product_fat_color).setImageResource(R.mipmap.ic_nutriscore_yellow_round)
        if(nutritionInfo.fat > 10)
            view.findViewById<ImageView>(R.id.product_fat_color).setImageResource(R.mipmap.ic_nutriscore_red_round)


        if(nutritionInfo.saturatedFattyAcid > 1 && nutritionInfo.saturatedFattyAcid <= 1.4 )
            view.findViewById<ImageView>(R.id.product_saturated_fatty_acids_color).setImageResource(R.mipmap.ic_nutriscore_yellow_round)
        if( nutritionInfo.saturatedFattyAcid > 1.4 )
            view.findViewById<ImageView>(R.id.product_saturated_fatty_acids_color).setImageResource(R.mipmap.ic_nutriscore_red_round)

        if(nutritionInfo.sugar > 4 && nutritionInfo.sugar <= 8 )
            view.findViewById<ImageView>(R.id.product_sugars_color).setImageResource(R.mipmap.ic_nutriscore_yellow_round)
        if( nutritionInfo.sugar > 8 )
            view.findViewById<ImageView>(R.id.product_sugars_color).setImageResource(R.mipmap.ic_nutriscore_red_round)

        if(nutritionInfo.salt > 1 && nutritionInfo.salt <= 3 )
            view.findViewById<ImageView>(R.id.product_salt_color).setImageResource(R.mipmap.ic_nutriscore_yellow_round)
        if( nutritionInfo.salt > 3 )
            view.findViewById<ImageView>(R.id.product_salt_color).setImageResource(R.mipmap.ic_nutriscore_red_round)
    }
}
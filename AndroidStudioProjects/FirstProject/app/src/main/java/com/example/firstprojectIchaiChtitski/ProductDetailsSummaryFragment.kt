package com.example.firstprojectIchaiChtitski

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.product_details_summary.*
import kotlinx.android.synthetic.main.product_details_summary.view.*

class ProductDetailsSummaryFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_summary,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = ProductDetailsFragmentArgs.fromBundle(requireParentFragment().requireParentFragment().requireArguments()).product

        view.findViewById<TextView>(R.id.product_title).text =  getString(R.string.product_title,product.nom)
        view.findViewById<TextView>(R.id.product_brand).text = getString(R.string.product_brand, product.marque)


        view.findViewById<TextView>(R.id.product_quantity).text = getString(R.string.product_quantity, product.quantité)

        view.findViewById<TextView>(R.id.product_sold).text = getString(R.string.product_sold, product.sold.toString())

        view.findViewById<TextView>(R.id.product_ingredients).text = getString(R.string.product_ingredients ,product.ingredients.toString())

        view.findViewById<TextView>(R.id.product_allergenic_substances).text = getString(R.string.allergicSubstances, product.allergicSubstances.toString())

        view.findViewById<TextView>(R.id.product_additives).text = getString(R.string.additif_substances, product.additifSubstances.toString())

        view.findViewById<ImageView>(R.id.product_image).setImageResource(product.urlImage)

    }



}
package com.example.firstprojectIchaiChtitski

import Domain.AdditifSubstances
import Domain.AllergicSubstances
import Domain.Europe
import Domain.Ingredients
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsListFragment:Fragment() {
    var products = listOf<Product>();
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val nutritionInfoPetitPoisCarrottes = NutritionInfo(0.8,0.1,5.2,0.75)
        val nutritionInfoKebab = NutritionInfo(15.3,2.1,1.0,3.5)
        val nutritionInfoCarrotes = NutritionInfo(4.3,1.1,7.5,5.0)

        products = listOf<Product>(Product(
            "kebab", "kebabMarque", 426969, "C",
            R.drawable.kebab, "6", Europe.getAll(), Ingredients.getAll(),
            AllergicSubstances.getAll(), AdditifSubstances.getAll(), 990,4
        ,nutritionInfoKebab),
            Product(
            "petitPoisCarrottes", "Bonduelle", 421312, "A",
            R.drawable.petit_pois_carottes, "6", Europe.getAll(), Ingredients.getAll(),
            AllergicSubstances.getAll(), AdditifSubstances.getAll(), 990,2,nutritionInfoPetitPoisCarrottes),
        Product(
            "Carrottes", "BioCoop", 421567, "B",
            R.drawable.carotte, "6", Europe.getAll(), Ingredients.getAll(),
            AllergicSubstances.getAll(), AdditifSubstances.getAll(), 990,2,nutritionInfoCarrotes))


        return inflater.inflate(
            R.layout.list_item,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(products.isNotEmpty()) {
            view.findViewById<RecyclerView>(R.id.products_list).run {
                adapter = ProductAdapter(products,
                    listener = object : ItemClickListener {
                        override fun onItemClicked(position: Int) {
                            findNavController().navigate(
                                ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(
                                    products[position]
                                )
                            )
                        }
                    })
                layoutManager = GridLayoutManager(requireContext(),1)
            }
        }

    }

}

//configuration de la liste de produits
class ProductAdapter(
    val products: List<Product>,
    val listener: ItemClickListener
) : RecyclerView.Adapter<ListProductsCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProductsCell {
        return ListProductsCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product, parent, false)
        )
    }

    override fun onBindViewHolder(listProductsCell: ListProductsCell, position: Int) {

        val product = products.get(position)

        listProductsCell.product_title.text =  product.nom
        listProductsCell.product_brand.text =  product.marque
        listProductsCell.product_nutriscore.text = product.nutriscore
        listProductsCell.product_calories.text = product.kCalories.toString()
        listProductsCell.product_image.setImageResource(product.urlImage)

        listProductsCell.itemView.setOnClickListener {
            listener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

}

//attribution des valeurs
class ListProductsCell(v: View) : RecyclerView.ViewHolder(v) {

    val product_title = v.findViewById<TextView>(R.id.product_title)
    val product_brand = v.findViewById<TextView>(R.id.product_brand)
    val product_nutriscore = v.findViewById<TextView>(R.id.product_nutriscore)
    val product_calories = v.findViewById<TextView>(R.id.product_calories)
    val product_image = v.findViewById<ImageView>(R.id.product_image)

}

interface ItemClickListener {
    fun onItemClicked(position: Int);
}

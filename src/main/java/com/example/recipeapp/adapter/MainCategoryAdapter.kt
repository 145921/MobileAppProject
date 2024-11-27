package com.example.recipeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.ExploreActivity
import com.example.recipeapp.RecipeActivity
import com.example.recipeapp.dao.RecipeDao
import com.example.recipeapp.database.RecipeDatabase
import com.example.recipeapp.databinding.ItemRecyclerMainCategoryBinding
import com.example.recipeapp.entities.Category
import com.example.recipeapp.entities.Recipes

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var ctx: Context? = null
    var arrayMainCategory = ArrayList<Category>()
    class RecipeViewHolder(
        val binding: ItemRecyclerMainCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(arrData: ArrayList<Category>){
        arrayMainCategory = arrData as ArrayList<Category>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ctx = parent.context
        val binding = ItemRecyclerMainCategoryBinding.inflate(layoutInflater, parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.binding.dishName.text = arrayMainCategory[position].category
        holder.binding.categoryView.setOnClickListener{
            val intent = Intent(ctx, ExploreActivity::class.java).apply {
                
            }
            ctx?.startActivity(intent)
        }
    }

    interface OnItemClickListener{
        fun OnClicked(categoryName: Int)
    }
}
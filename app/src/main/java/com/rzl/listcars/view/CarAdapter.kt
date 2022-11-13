@file:Suppress("KotlinDeprecation", "KotlinDeprecation", "KotlinDeprecation", "KotlinDeprecation",
    "RemoveRedundantQualifierName", "RemoveRedundantQualifierName", "RemoveEmptyClassBody",
    "RemoveEmptyClassBody", "unused", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "CanBeVal", "CanBeVal", "CanBeVal"
)

package com.rzl.listcars.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rzl.listcars.databinding.ItemCarBinding
import com.rzl.listcars.model.ResponseDataCarItem

@Suppress("KotlinDeprecation", "KotlinDeprecation", "KotlinDeprecation", "KotlinDeprecation",
    "RemoveRedundantQualifierName", "RemoveRedundantQualifierName", "RemoveEmptyClassBody",
    "RemoveEmptyClassBody", "unused", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "CanBeVal", "CanBeVal", "CanBeVal"
)
class CarAdapter(var listcar : List<ResponseDataCarItem>): RecyclerView.Adapter<CarAdapter.ViewHolder>() {


    var onDetail : ((ResponseDataCarItem)->Unit)? = null

    class ViewHolder(var binding : ItemCarBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        var view = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameCar.text = listcar!![position].name
        holder.binding.categoryCar.text = listcar!![position].category
        holder.binding.priceCar.text = listcar!![position].price.toString()
        Glide.with(holder.itemView.context).load(listcar!![position].image)
            .into(holder.binding.imgCar)


        holder.binding.klikDetail.setOnClickListener {
            var a = Bundle()
            val inten = Intent(it.context, DetailActivity::class.java)
            a.putInt("detail", listcar[position].id)
            inten.putExtras(a)
            it.context.startActivity(inten)
        }
    }

    override fun getItemCount(): Int {

        return listcar.size

    }
}
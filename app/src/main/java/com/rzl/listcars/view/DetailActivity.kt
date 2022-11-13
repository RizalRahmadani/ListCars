@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "RedundantSamConstructor",
    "RedundantSamConstructor", "ReplaceGetOrSet", "ReplaceGetOrSet", "CanBeVal"
)

package com.rzl.listcars.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rzl.listcars.R
import com.rzl.listcars.databinding.ActivityDetailBinding
import com.rzl.listcars.model.ResponseDataCarItem
import com.rzl.listcars.viewmodel.ViewModelCar
import dagger.hilt.android.AndroidEntryPoint

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "RedundantSamConstructor",
    "RedundantSamConstructor", "ReplaceGetOrSet", "ReplaceGetOrSet", "CanBeVal"
)
@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    lateinit var dataCar : ResponseDataCarItem

    private var b:Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        b = intent.extras
        var id = b!!.getInt("detail")
        Log.d("id", id.toString())
        getDetailCar(id)

    }



    private fun getDetailCar(id : Int){
        val viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callDetailCar(id)
        viewModel.getDetailCar(id).observe(this, Observer {
//            binding.nameCarDetail.setText("Merek : "+ it!!.name)
//            binding.categoryCarDetail.setText("Kategori : "+ it!!.category)
//            binding.priceCarDetail.setText("Harga : "+ it!!.price)
//            Glide.with(this).load(dataCar.image).into(binding.imgCarDetail)

        })

    }
}
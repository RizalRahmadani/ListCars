@file:Suppress("RedundantSamConstructor", "UnusedImport", "unused")

package com.rzl.listcars.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rzl.listcars.R
import com.rzl.listcars.databinding.ActivityMainBinding
import com.rzl.listcars.viewmodel.ViewModelCar
import dagger.hilt.android.AndroidEntryPoint

@Suppress("RedundantSamConstructor", "unused", "unused", "unused", "unused", "unused")
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding
    private lateinit var carAdapter : CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setVmtoAdapter()
    }

    private fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this)[ViewModelCar::class.java]
        viewModel.callApiCar()
        viewModel.getliveDataCar().observe(this, Observer {
            carAdapter = CarAdapter(it)
            if ( it != null){
                binding.rvCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvCar.adapter = CarAdapter(it)

            }

        })
    }
}
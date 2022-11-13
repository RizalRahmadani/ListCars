@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused"
)

package com.rzl.listcars.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rzl.listcars.model.ResponseDataCarItem
import com.rzl.listcars.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@Suppress("JoinDeclarationAndAssignment", "unused", "unused", "unused")
@HiltViewModel
class ViewModelCar @Inject constructor(private var api : RestfulApi) : ViewModel(){

    lateinit var liveDataCar: MutableLiveData<List<ResponseDataCarItem>>
    lateinit var detailDataCar: MutableLiveData<ResponseDataCarItem>
//    lateinit var detailDataCar : MutableLiveData<List<ResponseDataCarItem>>



    init {
        liveDataCar = MutableLiveData()
        detailDataCar = MutableLiveData()


    }

    fun getliveDataCar() : MutableLiveData<List<ResponseDataCarItem>> {
        return  liveDataCar
    }
    fun getDetailCar(id : Int) : MutableLiveData<ResponseDataCarItem> {
        return  detailDataCar
    }





    fun callApiCar(){
        api.getAllCar().enqueue(object : Callback<List<ResponseDataCarItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataCarItem>>,
                response: Response<List<ResponseDataCarItem>>
            ) {
                if (response.isSuccessful){
                    liveDataCar.postValue(response.body())
                }else{
                    liveDataCar.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                liveDataCar.postValue(null)
            }

        })
    }
    fun callDetailCar(id : Int){
        api.getDetailCar(id)
            .enqueue(object : Callback<ResponseDataCarItem> {
                override fun onResponse(
                    call: Call<ResponseDataCarItem>,
                    response: Response<ResponseDataCarItem>
                ) {
                    if(response.isSuccessful){
                        detailDataCar.postValue(response.body())
                    }else{
                        detailDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseDataCarItem>, t: Throwable) {
                    detailDataCar.postValue(null)
                }

            })
    }


}
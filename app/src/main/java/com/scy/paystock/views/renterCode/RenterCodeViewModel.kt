package com.scy.paystock.views.renterCode


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.converter.gson.GsonConverterFactory
class RenterCodeViewModel : ViewModel() {


    private val apiService = RetrofitInstance.api
    val response : MutableState<ResponseData> = mutableStateOf(ResponseData(isSuccess = false))
    fun checkRenterCode(code : Long) {
        viewModelScope.launch {
            try {
                val response = apiService.postData(renter = RenterDto(id = code))
                print(response)

            } catch (e: Exception) {
                print(e)
                // Handle errors here
            }
        }
    }
}



data class RenterDto(
    val id: Long
)

data class ResponseData(
    val isSuccess: Boolean
)


interface ApiService {
    @POST("check")
    suspend fun postData(@Body renter: RenterDto): ResponseData
}


object RetrofitInstance {
    private
    const val BASE_URL = "http://192.168.1.106:9090/"
    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}
package com.scy.paystock.network

import com.scy.paystock.views.login.LoginDto
import com.scy.paystock.views.renterCode.RenterDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("check")
    suspend fun checkRenterCode(@Body renter: RenterDto): ResponseDataStatus

    @POST("authentication")
    suspend fun authentication(@Body userCredential: LoginDto): ResponseDataStatus
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


data class ResponseDataStatus(
    val isSuccess: Boolean
)
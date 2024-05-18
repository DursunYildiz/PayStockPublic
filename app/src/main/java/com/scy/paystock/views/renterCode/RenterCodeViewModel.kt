package com.scy.paystock.views.renterCode


import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scy.paystock.network.ResponseDataStatus
import com.scy.paystock.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Retrofit

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.converter.gson.GsonConverterFactory
class RenterCodeViewModel : ViewModel() {


    private val apiService = RetrofitInstance.api
    val _response : MutableState<ResponseDataStatus> = mutableStateOf(ResponseDataStatus(isSuccess = false))
    fun checkRenterCode(code: Long) {
        viewModelScope.launch {
            try {
                val response = apiService.checkRenterCode(renter = RenterDto(id = code))
                _response.value = response

            } catch (e: Exception) {
                e.message?.let { Log.d("Hataaaa" , it) }
                // Handle errors here
            }
        }
    }
}


data class RenterDto(
    val id: Long
)




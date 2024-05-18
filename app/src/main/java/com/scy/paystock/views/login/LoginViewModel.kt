package com.scy.paystock.views.login

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scy.paystock.network.ResponseDataStatus
import com.scy.paystock.network.RetrofitInstance
import com.scy.paystock.views.renterCode.RenterDto
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api

    private val _username = mutableStateOf("")
    val username: String by _username

    private val _password = mutableStateOf("")
    val password: String by _password


    val _response : MutableState<ResponseDataStatus> = mutableStateOf(ResponseDataStatus(isSuccess = false))


    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun login(username: String, password: String) {
        // Simulate login logic (replace with actual authentication)
        viewModelScope.launch {


            try {
                val response = apiService.authentication(LoginDto(username,password))
                _response.value = response

            } catch (e: Exception) {
                e.message?.let { Log.d("Hataaaa" , it) }
                // Handle errors here
            }
        }
    }
}

data class LoginResponse(val isSuccess: Boolean) {

}
data class LoginDto(
    val username: String,
    val password: String
)

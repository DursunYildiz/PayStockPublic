package com.scy.paystock.views.renterCode

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.scy.paystock.views.renterCode.ui.theme.PayStockTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RenterCodeView(viewModel: RenterCodeViewModel = RenterCodeViewModel(),
                   navController: NavController
) {
    var text by remember { mutableStateOf("") }

    Scaffold {
        TopAppBar(
            title = { Text("My App") }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center // Center items vertically
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    if (newText.all { it.isDigit() }) {
                        text = newText
                    }
                },
                label = { Text("Kiracı Kodu") },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 40.dp)// Center horizontally
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End), // Align button to bottom center
                onClick = {
                    navController.navigate(route = "Login")
                    if (text.isNotEmpty()) {
                        viewModel.checkRenterCode(text.toLong())
                        // Consider adding success/error handling based on viewModel response
                        // You can use Snackbar or Toast for user feedback
                        Log.d("MyComposableUI", "Button clicked! Renter code: ${text.toInt()}")
                    }
                }
            ) {
                Text("Giriş Yap")
            }
            LaunchedEffect(viewModel._response) {
                val response = viewModel._response.value
                if (response.isSuccess) {
                    // Navigate to the next screen using the navigator
                    navController.navigate("")// Implement navigation logic here
                }
            }
        }
    }
}


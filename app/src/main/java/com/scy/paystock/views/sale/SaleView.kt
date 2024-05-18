package com.scy.paystock.views.sale

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.scy.paystock.views.login.ui.theme.PayStockTheme

@Composable
fun SaleView(navController: NavHostController) {
    Text(text = "dsadsadsa")
}
@Preview(showBackground = true)
@Composable
fun SaleViewPreview() {
    PayStockTheme {
        SaleView( navController = rememberNavController())
    }
}
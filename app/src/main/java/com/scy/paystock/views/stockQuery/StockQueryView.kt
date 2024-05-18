package com.scy.paystock.views.stockQuery

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.scy.paystock.views.login.ui.theme.PayStockTheme

@Composable
fun StockQueryView(navController: NavHostController) {
    Text(text = "dsadsadsa")
}
@Preview(showBackground = true)
@Composable
fun StockQueryViewPreview() {
    PayStockTheme {
        StockQueryView( navController = rememberNavController())
    }
}
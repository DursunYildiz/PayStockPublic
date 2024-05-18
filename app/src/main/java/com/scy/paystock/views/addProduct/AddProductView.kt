package com.scy.paystock.views.addProduct

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.scy.paystock.views.login.ui.theme.PayStockTheme


@Composable
fun AddProductView(navController: NavHostController) {

}
@Preview(showBackground = true)
@Composable
fun AddProductViewPreview() {
    PayStockTheme {
        AddProductView( navController = rememberNavController())
    }
}
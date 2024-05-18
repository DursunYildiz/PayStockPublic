package com.scy.paystock.navigation

enum class Screen {
    RenterCode,
    LOGIN,
    Splash,
    Home,
    Sale,
    AddProduct,
    StockQuery,
    SaleReport,
    Notes
}
sealed class NavigationItem(val route: String) {
    object RenterCode : NavigationItem(Screen.RenterCode.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Splash : NavigationItem(Screen.Splash.name)
    object StockQuery : NavigationItem(Screen.StockQuery.name)
    object AddProduct : NavigationItem(Screen.AddProduct.name)
    object SaleReport : NavigationItem(Screen.SaleReport.name)
    object Notes : NavigationItem(Screen.Notes.name)
    object Sale : NavigationItem(Screen.Sale.name)
    object Home : NavigationItem(Screen.Home.name)
}



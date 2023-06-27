package com.thariqzs.composedemo.ui.nav

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about")
    object DetailShoe : Screen("home/{shoeId}") {
        fun createRoute(shoeId: Int) = "home/$shoeId"
    }
}
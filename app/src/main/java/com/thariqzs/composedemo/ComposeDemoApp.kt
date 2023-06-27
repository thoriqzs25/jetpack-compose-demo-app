package com.thariqzs.composedemo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.thariqzs.composedemo.ui.nav.Screen
import com.thariqzs.composedemo.ui.screen.AboutScreen
import com.thariqzs.composedemo.ui.screen.DetailScreen
import com.thariqzs.composedemo.ui.screen.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeDemoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.About.route) {
                AboutScreen(navController = navController)
            }
            composable(
                Screen.DetailShoe.route,
                arguments = listOf(navArgument("shoeId") { type = NavType.IntType }),
            ) {
                val id = it.arguments?.getInt("shoeId") ?: -1L
                DetailScreen(
                    navController = navController,
                    navigateBack = { navController.navigateUp() },
                    shoeId = id.toInt()
                )
            }
        }
    }
}
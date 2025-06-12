package com.example.uipagessolarbee.ui.theme

import InventoryDashboard
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uipagessolarbee.DashboardScreen
import com.example.uipagessolarbee.LoginScreen

@Composable
fun AppNavigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN.name) {

        composable(route = Routes.LOGIN.name) {
            LoginScreen(navController = navController)
        }

        composable(route = Routes.ADMIN_DASHBOARD.name) {
            DashboardScreen(navController = navController)
        }

        composable(route = Routes.INVENTORY.name) {
            InventoryDashboard(navController)
        }

        composable(route = Routes.SIGNUP.name) {
            SignUpScreen(
                navController =navController
            )
        }

        composable(route = Routes.WAREHOUSE.name) {

        }

    }

}


enum class Routes {
    LOGIN,
    ADMIN_DASHBOARD,
    INVENTORY,
    SIGNUP,
    // Add these missing routes
    WAREHOUSE,
    PRODUCTS,
    ANALYTICS,
    REPORTS,
    SETTINGS,
    CATEGORIES,
    SUPPLIERS,
    ORDERS
}

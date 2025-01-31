package com.example.hotelbooking.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hotelbooking.HomeScreen

object EndPoints {
    const val ID = "id"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Route.AuthRoute.route
    ) {
        authNavGraph(navController)
        composable(route = Route.HomeScreen.route){
            BackHandler(true) {}

            HomeScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
    const val PROPERTIES = "properties_graph"
}

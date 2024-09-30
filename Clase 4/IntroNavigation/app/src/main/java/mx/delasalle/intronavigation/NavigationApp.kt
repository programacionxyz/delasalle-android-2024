package mx.delasalle.intronavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.delasalle.intronavigation.ui.screens.DetailScreen
import mx.delasalle.intronavigation.ui.screens.MainScreen

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen(navController)
        }
        /*composable("detail_screen") {
            DetailScreen("Other Text")
        }*/

        composable("detail_screen/{capturedText}"){
            navBackStackEntry ->
            val captureText = navBackStackEntry.arguments?.getString("capturedText")
            captureText?.let{
               DetailScreen(navController,text = it)
            }
        }


    }

}

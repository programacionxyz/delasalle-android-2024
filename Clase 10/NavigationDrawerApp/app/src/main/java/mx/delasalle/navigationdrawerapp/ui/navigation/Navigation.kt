package mx.delasalle.navigationdrawerapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.delasalle.navigationdrawerapp.ui.screens.HomeScreen
import mx.delasalle.navigationdrawerapp.ui.screens.ProfileScreen
import mx.delasalle.navigationdrawerapp.ui.screens.SettingsScreen

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController= navController, startDestination = "home", modifier = modifier){
        composable("home"){ HomeScreen()}
        composable("settings"){ SettingsScreen()}
        composable("profile"){ ProfileScreen()}
    }
}
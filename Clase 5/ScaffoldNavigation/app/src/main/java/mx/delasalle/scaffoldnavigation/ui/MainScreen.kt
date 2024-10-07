package mx.delasalle.scaffoldnavigation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.delasalle.scaffoldnavigation.ui.navigation.NavigationAppBar
import mx.delasalle.scaffoldnavigation.ui.navigation.Screen
import mx.delasalle.scaffoldnavigation.ui.navigation.TopBar
import mx.delasalle.scaffoldnavigation.ui.screens.HomeScreen
import mx.delasalle.scaffoldnavigation.ui.screens.ProfileScreen
import mx.delasalle.scaffoldnavigation.ui.screens.SettingsScreen

@Composable
fun MainScreen(){
   val navController = rememberNavController()
   Scaffold(
      bottomBar = { NavigationAppBar(navController)},
      topBar = { TopBar(title = "Inicio") }
   ) { innerPadding ->
      NavHost(
         navController = navController,
         startDestination = Screen.Home.route,
         modifier = Modifier.padding(innerPadding)
      ){
         composable(Screen.Home.route){ HomeScreen(innerPadding ) }
         composable(Screen.Profile.route){ ProfileScreen(innerPadding ) }
         composable(Screen.Settings.route){ SettingsScreen(innerPadding ) }
      }
   }
}
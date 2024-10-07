package mx.delasalle.scaffoldnavigation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String,val title:String, val icon:ImageVector){
    data object Home :Screen("home", "Inicio",Icons.Default.Home,)
    data object Profile :Screen("profile", "Perfil",Icons.Default.Person,)
    data object Settings :Screen("settings", "Configuración",Icons.Default.Settings,)
}



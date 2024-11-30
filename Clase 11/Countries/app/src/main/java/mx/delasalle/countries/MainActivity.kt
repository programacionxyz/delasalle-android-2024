package mx.delasalle.countries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room.databaseBuilder
import mx.delasalle.countries.datasources.CountryDatabase
import mx.delasalle.countries.datasources.RetrofitInstance
import mx.delasalle.countries.repositories.CountryRepository
import mx.delasalle.countries.ui.screens.CountryListScreen
import mx.delasalle.countries.ui.theme.CountriesTheme
import mx.delasalle.countries.ui.viewmodels.CountryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = databaseBuilder(
            applicationContext,
            CountryDatabase::class.java,"country_database"
        ).build()

        val api = RetrofitInstance.api
        val countryRepository = CountryRepository(api,db.countryDao())
        val countryViewModel =  CountryViewModel (countryRepository)

        setContent {
            CountriesTheme {
                CountryListScreen(countryViewModel)
            }
        }
    }
}

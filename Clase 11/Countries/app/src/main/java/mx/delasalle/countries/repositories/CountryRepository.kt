package mx.delasalle.countries.repositories

import kotlinx.coroutines.flow.first
import mx.delasalle.countries.dao.CountryDao
import mx.delasalle.countries.datasources.CountryApiService
import mx.delasalle.countries.datasources.RetrofitInstance
import mx.delasalle.countries.model.Country
import mx.delasalle.countries.model.CountryItem
import mx.delasalle.countries.model.Flags
import mx.delasalle.countries.model.Name

class CountryRepository(private val api: CountryApiService) {

    suspend fun getCountries(): List<Country> {
        val result = api.getAllCountries()
        return result
    }
}
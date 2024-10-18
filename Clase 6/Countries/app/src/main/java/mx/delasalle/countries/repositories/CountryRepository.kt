package mx.delasalle.countries.repositories

import mx.delasalle.countries.datasources.RetrofitInstance
import mx.delasalle.countries.model.Country

class CountryRepository {
    private val api = RetrofitInstance.api
    suspend fun getCountries():List<Country>{
        val result = api.getAllCountries()
        return result
    }
}
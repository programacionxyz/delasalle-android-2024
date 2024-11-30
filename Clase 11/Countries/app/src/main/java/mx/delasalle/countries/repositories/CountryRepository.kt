package mx.delasalle.countries.repositories

import kotlinx.coroutines.flow.first
import mx.delasalle.countries.dao.CountryDao
import mx.delasalle.countries.datasources.CountryApiService
import mx.delasalle.countries.datasources.RetrofitInstance
import mx.delasalle.countries.model.Country
import mx.delasalle.countries.model.CountryItem
import mx.delasalle.countries.model.Flags
import mx.delasalle.countries.model.Name

class CountryRepository(
    private val api: CountryApiService,
    private val countryDao: CountryDao
) {

    suspend fun getCountries(): List<Country> {
        try {
            val result = api.getAllCountries()
            result.forEach { country ->
                val countryItem = CountryItem(
                    id = 0,
                    name = country.name.common,
                    capital = country.capital?.joinToString(", ") ?: "NA"
                )
                countryDao.insert(countryItem)
            }
            return result
        } catch (e: Exception) {
            val countries:MutableList<Country> = mutableListOf()
            val countryItemList = countryDao.getAllCountries().first()
            countryItemList.map{ countryItem ->
                countries.add(Country(
                    name = Name( common = countryItem.name, official = ""),
                    capital = listOf(countryItem.capital),
                    flags = Flags(png = null, svg = null)
                ))
            }
            return countries
        }
    }
}
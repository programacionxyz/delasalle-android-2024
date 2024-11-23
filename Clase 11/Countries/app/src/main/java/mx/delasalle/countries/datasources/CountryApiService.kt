package mx.delasalle.countries.datasources

import mx.delasalle.countries.model.Country
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryApiService {
    @GET("https://restcountries.com/v3.1/all")
    suspend fun getAllCountries():List<Country>

    @GET("v3.1/all")
    suspend fun getAllCountries(
        @Query("fields") fields:String="name,capital,flags"
    ):List<Country>
}
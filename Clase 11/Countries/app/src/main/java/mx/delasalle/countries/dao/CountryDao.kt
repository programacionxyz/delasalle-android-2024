package mx.delasalle.countries.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mx.delasalle.countries.model.CountryItem

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(countryItem: CountryItem)

    @Query("SELECT * FROM country_table")
    fun getAllCountries() : kotlinx.coroutines.flow.Flow<List<CountryItem>>
}



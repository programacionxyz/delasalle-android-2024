package mx.delasalle.countries.datasources

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.delasalle.countries.dao.CountryDao
import mx.delasalle.countries.model.CountryItem

@Database(entities = [CountryItem::class], version = 1)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
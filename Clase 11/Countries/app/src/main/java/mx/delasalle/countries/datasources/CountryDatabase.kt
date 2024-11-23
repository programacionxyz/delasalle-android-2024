package mx.delasalle.countries.datasources

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.delasalle.countries.dao.CountryDao
import mx.delasalle.countries.model.CountryItem

abstract class CountryDatabase : RoomDatabase() {
}

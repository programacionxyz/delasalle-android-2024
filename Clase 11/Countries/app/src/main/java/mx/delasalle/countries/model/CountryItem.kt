package mx.delasalle.countries.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country_table")
data class CountryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val capital: String
)

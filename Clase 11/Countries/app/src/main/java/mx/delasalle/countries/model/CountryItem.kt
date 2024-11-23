package mx.delasalle.countries.model


import androidx.room.Entity
import androidx.room.PrimaryKey

data class CountryItem(
    val id: Int = 0,
    val name: String,
    val capital: String
)

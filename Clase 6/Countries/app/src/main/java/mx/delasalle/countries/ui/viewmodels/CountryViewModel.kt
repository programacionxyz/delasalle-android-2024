package mx.delasalle.countries.ui.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mx.delasalle.countries.model.Country
import mx.delasalle.countries.repositories.CountryRepository

sealed class CountryUiState{
    object Loading:CountryUiState()
    data class Success (val countries:List<Country>) : CountryUiState()
    data class Error(val message:String):CountryUiState()
}

class CountryViewModel(
    private val repository:CountryRepository = CountryRepository()
) : ViewModel(){

    private val _uiState = MutableStateFlow<CountryUiState>(CountryUiState.Loading)
    val uiState:StateFlow<CountryUiState> = _uiState

    init{
        fetchCountries()
    }

    private fun fetchCountries(){
        viewModelScope.launch {
            try{
                _uiState.value = CountryUiState.Loading
                val countries = repository.getCountries()
                _uiState.value = CountryUiState.Success(countries)
            } catch (e:Exception){
                _uiState.value = CountryUiState.Error(e.localizedMessage ?:
                "An unexpected error occurred")
            }
        }
    }

}
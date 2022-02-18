package com.example.segundaprova.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.segundaprova.data.Restaurante
import com.example.segundaprova.data.RestauranteDatabase
import com.example.segundaprova.data.RestauranteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RestaurantesViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Restaurante>>
    private val repository: RestauranteRepository

    init {
        val userDao = RestauranteDatabase.getDatabase(application).restauranteDao()
        repository = RestauranteRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addRestaurante(restaurante: Restaurante){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRestaurante(restaurante)
        }
    }

    fun addEstadoRemote(estado: List<Restaurante>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRestauranteoRemote(estado)
        }
    }

    fun updateRestaurante(restaurante: Restaurante){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRestaurante(restaurante)
        }
    }

    fun detailRestaurante(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            repository.detailRestaurante(id)
        }
    }
}
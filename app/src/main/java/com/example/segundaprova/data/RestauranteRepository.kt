package com.example.segundaprova.data

import androidx.lifecycle.LiveData

class RestauranteRepository(private val restauranteDao: RestauranteDAO) {

    val readAllData: LiveData<List<Restaurante>> = restauranteDao.listAll()

    suspend fun addRestaurante(restaurante: Restaurante){
        restauranteDao.inserir(restaurante)
    }

    suspend fun addRestauranteoRemote (estado: List<Restaurante>){
        restauranteDao.insertRemote(estado)
    }

    suspend fun updateRestaurante(restaurante: Restaurante){
        restauranteDao.atualizar(restaurante)
    }

    suspend fun detailRestaurante(id: Long){
        restauranteDao.findById(id)
    }
}
package com.example.segundaprova.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RestauranteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun inserir(restaurante: Restaurante): Long


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRemote(estado: List<Restaurante>)

    @Delete
    fun deletar(restaurante: Restaurante): Int

    @Delete
    fun deletarVarios(vararg restaurante: Restaurante)

    @Query("DELETE FROM tabela_restaurante")
    fun deletaTodos()

    @Update
    fun atualizar(restaurante: Restaurante): Int

    @Query("SELECT * FROM tabela_restaurante ORDER BY id ASC")
    fun listAll(): LiveData<List<Restaurante>>

    @Query("SELECT * FROM TABELA_RESTAURANTE WHERE id = :id")
    fun findById(id: Long): Restaurante

    @Query("SELECT * FROM TABELA_RESTAURANTE WHERE nome = :nome")
    fun findByName (nome: String) : Restaurante

}
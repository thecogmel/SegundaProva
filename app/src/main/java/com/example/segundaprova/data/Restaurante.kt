package com.example.segundaprova.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabela_restaurante")
data class Restaurante(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nome: String,
    var tipo: String,
    var horario: String,
    @ColumnInfo(name = "num_funcionarios")
    var num_funcionarios: Int,
    var capacidade: Int
): Parcelable
package com.example.segundaprova.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Restaurante::class], version = 1, exportSchema = false)
abstract class RestauranteDatabase : RoomDatabase() {

    abstract fun restauranteDao(): RestauranteDAO

    companion object {
        @Volatile
        private var INSTANCE: RestauranteDatabase? = null

        fun getDatabase(context: Context): RestauranteDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestauranteDatabase::class.java,
                    "restaurante_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
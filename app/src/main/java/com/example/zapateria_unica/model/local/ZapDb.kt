package com.example.zapateria_unica.model.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ZapEntity::class],[ZapdetailsEntity::class], version=1, exportSchema=false)
abstract class ZapDb: RoomDatabase() {


    abstract fun getZapDao(): zapDao

    companion object {
        @Volatile
        private var
                INSTANCE : ZapDb? = null
        fun getDataBase(context: Context) : ZapDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ZapDb::class.java, "_zapDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
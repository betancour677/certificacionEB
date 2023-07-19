package com.example.zapateria_unica.model.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface zapDao {
       //Insertar Lista
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun Insertallzaps(Listzaps: List<ZapEntity>)

        //Insertar Elemento

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun Insertarzap(Zap:ZapEntity)

        //obtener listado de zapatillas
        @Query("SELECT*FROM Zapatillas ORDER BY id ASC")
        fun getAllZaps(): LiveData<List<ZapEntity>>

        //obtener detalle zapatillas
        @Query("SELECT*FROM DETALLESZAP ORDER BY id ASC")
        fun getdetailszap():LiveData<List<ZapdetailsEntity>>


 @Insert(onConflict = OnConflictStrategy.REPLACE)
 suspend fun Insertdetailszap(Zapdet:ZapdetailsEntity)
}
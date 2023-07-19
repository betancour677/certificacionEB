package com.example.zapateria_unica.model.local
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity (tableName="detallesZap")
data class ZapdetailsEntity (

    @PrimaryKey
    @NotNull
    val id: Int,
    val nombre: String,
    val imagelink: String,
    val origen: String,
    val marca: String,
    val numero:String,
    val precio:String,
)


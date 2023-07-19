package com.example.zapateria_unica.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity (tableName="Zapatillas")
data class ZapEntity (
    @PrimaryKey
    @NotNull
    val id: Int,
    val nombre: String,
    val imagelink: String,
)
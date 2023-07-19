package com.example.zapateria_unica

import com.example.zapateria_unica.model.local.ZapEntity
import com.example.zapateria_unica.model.local.ZapdetailsEntity
import com.example.zapateria_unica.model.remote.Zapatilla
import com.example.zapateria_unica.model.remote.ZapatillaDetalles


fun fromInternetToZapentity(ZapList: List<Zapatilla>):List<ZapEntity> {
    return ZapList.map {
        ZapEntity(
            id = it.id,
            nombre = it.nombre,
            imagelink = it.imagelink

        )
    }
}

fun fromInternetToZapDetailsEntity(ZapDetailList: List<ZapatillaDetalles>):List<ZapdetailsEntity> {
    return ZapDetailList.map {
        ZapdetailsEntity(
            id = it.id,
            nombre = it.nombre,
            imagelink=it.imagelink,
            origen=it.origen,
            marca=it.marca,
            numero=it.numero,
            precio=it.precio

        )
    }
}

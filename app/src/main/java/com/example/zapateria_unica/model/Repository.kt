package com.example.zapateria_unica.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.zapateria_unica.fromInternetToZapDetailsEntity
import com.example.zapateria_unica.fromInternetToZapentity
import com.example.zapateria_unica.model.local.ZapdetailsEntity
import com.example.zapateria_unica.model.local.zapDao
import com.example.zapateria_unica.model.remote.RetrofitClient
import com.example.zapateria_unica.model.remote.ZapatillaDetalles


class Repository(private val _ZapDao:zapDao){
    private val networkService = RetrofitClient.retrofitInstance()

    val zapListLiveData= _ZapDao.getAllZaps()

    //Variable local
    val zapDetailLiveData = MutableLiveData<ZapdetailsEntity>()


    suspend fun fetchzapatillas(){
        val service = kotlin.runCatching { networkService.fetchzapList()}
        service.onSuccess {
            when(it.code()){
                in 200..299-> it.body()?.let {

                    _ZapDao.Insertallzaps(fromInternetToZapentity(it))
                }

                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error","${it.message}")
            }

        }

    }


    suspend fun fetchzapatilladetail(id: String): ZapdetailsEntity? {
        val service = kotlin.runCatching { networkService.fetchzapatilladetail(id) }
        return service.getOrNull()?.body()?.let { zapatilladetalles ->

            val zapdetailsEntity = fromInternetToZapDetailsEntity(zapatilladetalles)

            _ZapDao.Insertdetailszap(ZapdetailsEntity)
            zapdetailsEntity
        }
    }

}
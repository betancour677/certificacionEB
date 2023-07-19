package com.example.zapateria_unica.ViewModel

    import android.app.Application
    import androidx.lifecycle.AndroidViewModel
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.viewModelScope
    import com.example.zapateria_unica.model.Repository
    import com.example.zapateria_unica.model.local.ZapDb
    import com.example.zapateria_unica.model.local.ZapEntity
    import com.example.zapateria_unica.model.local.ZapdetailsEntity
    import kotlinx.coroutines.launch

class ZapViewModel (application: Application): AndroidViewModel(application){

        // conexion repositorio
        private val repository: Repository

        // entidad
        private val ZapdetailslLiveData = MutableLiveData<ZapdetailsEntity>()

        private  var idSelected: String ="-1"

        init{
            val bd= ZapDb.getDataBase(application)
            val  zapDao = bd.getZapDao()

            repository = Repository(zapDao)

            // lama el método del respositorio
            viewModelScope.launch {

                repository.fetchzapatillas()
            }
        }

        // listado de elementos

        fun getZapList(): LiveData<List<ZapEntity>> = repository.zapListLiveData

        // obtener el detalle envuelto en liveData
        fun getZapDetail(): LiveData<ZapdetailsEntity> = ZapdetailslLiveData


        // funcion para seleccionar elemento

        fun getZapDetailByIDFromInternet(id:String) = viewModelScope.launch {

            val zapdetail = repository.fetchzapatilladetail(id)
            zapdetail?.let {

                ZapdetailslLiveData.postValue(it)
            }
        }
}




package com.example.zapateria_unica.model.remote


    import retrofit2.Response
    import retrofit2.http.GET
    import retrofit2.http.Path

    interface zapApi {
        @GET("shoes")
        suspend fun fetchzapList(): Response<List<Zapatilla>>

        @GET("shoes/{id}")
        suspend fun fetchzapatilladetail(@Path("id")id:String): Response<List<ZapatillaDetalles>>

    }

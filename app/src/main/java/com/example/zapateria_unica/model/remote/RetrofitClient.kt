package com.example.zapateria_unica.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private const val BASE_URL = "https://prueba-mariocanedo.vercel.app/"
        lateinit var retrofitInstance: Retrofit
        fun retrofitInstance():zapApi{
            val retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(zapApi::class.java)
        }
    }
}
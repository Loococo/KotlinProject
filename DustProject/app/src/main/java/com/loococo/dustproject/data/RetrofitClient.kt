package com.loococo.dustproject.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//싱글턴 => 객체의 인스턴스를 1개만 생성해 재활용해서 사용하는 패턴
object RetrofitClient {
    private const val BASE_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/"

    fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            ).build()
}
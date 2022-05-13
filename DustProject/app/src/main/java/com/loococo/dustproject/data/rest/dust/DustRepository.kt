package com.loococo.dustproject.data.rest.dust

import com.loococo.dustproject.data.RetrofitClient

object DustRepository {
    // 호출될 때 메모리에 올라가게 작업
    private val dustService: DustService by lazy {
        RetrofitClient.getRetrofit().create(DustService::class.java)
    }

    suspend fun getDustService(param: HashMap<String, String>) = dustService.requestDust(param)
}
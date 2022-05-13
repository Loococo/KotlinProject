package com.loococo.dustproject.data.rest.dust

import com.loococo.dustproject.data.model.Dust
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface DustService {
    @GET("getMsrstnAcctoRltmMesureDnsty")
    suspend fun requestDust(@QueryMap param: HashMap<String, String>): Dust
}
package com.loococo.dustproject.data.model

import com.google.gson.annotations.SerializedName
import com.loococo.dustproject.R

data class Dust(val response: DustResponse?)

data class DustResponse(
    @SerializedName("body")
    val dustBody: DustBody?,
    @SerializedName("header")
    val dustHeader: DustHeader?
)

data class DustBody(
    val totalCount: Int,
    @SerializedName("items")
    val dustItem: MutableList<DustItem>?,
    val pageNo: Int,
    val numOfRows: Int
)

data class DustHeader(
    val resultCode: String,
    val resultMsg: String
)

data class DustItem(
    val so2Grade: DustGrade,
    val coFlag: String?,
    val khaiValue: String,
    val so2Value: String,
    val coValue: String,
    val pm10Value: String,
    val pm10Flag: String?,
    val pm10Grade: DustGrade,
    val pm25Value: String,
    val pm25Flag: String?,
    val pm25Grade: DustGrade,
    val o3Grade: DustGrade,
    val khaiGrade: DustGrade,
    val no2Flag: String?,
    val no2Grade: DustGrade,
    val o3Flag: String?,
    val so2Flag: String,
    val dataTime: String,
    val coGrade: DustGrade,
    val no2Value: String,
    val o3Value: String
)

enum class DustGrade(
    val state: String,
    val color: Int
) {
    @SerializedName("1")
    GOOD("좋음", R.color.dust_good),

    @SerializedName("2")
    NORMAL("보통", R.color.dust_normal),

    @SerializedName("3")
    BAD("나쁨", R.color.dust_bad),

    @SerializedName("4")
    VERY_BAD("매우나쁨", R.color.dust_very_bad);
}
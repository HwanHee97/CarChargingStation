package com.example.carchargingstation.network

import com.example.carchargingstation.rpdatamodel.ChargingStationState
import com.example.carchargingstation.utils.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface IRetrofit {
    @GET(API.SEARCH)
    fun getSearchData(
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("addr") addr: String
    ): Call<ChargingStationState>

}
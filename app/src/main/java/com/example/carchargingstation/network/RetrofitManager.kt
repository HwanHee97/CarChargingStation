package com.example.carchargingstation.network

import com.example.carchargingstation.RpDataModel.ChargingStationState
import com.example.carchargingstation.utils.API
import com.example.carchargingstation.utils.RESPONSE_STATUS
import retrofit2.Call
import retrofit2.Response


class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)
    private lateinit var call: Call<ChargingStationState>
    fun callChargingStationData(addr:String ,pageno:Int ,numofrows:Int ,completion: (RESPONSE_STATUS, ChargingStationState?) -> Unit) {

        call=iRetrofit?.getSearchData(addr = addr ,pageNo =pageno ,numOfRows = numofrows).let { it } ?: return

        call.enqueue(object : retrofit2.Callback<ChargingStationState> {
            override fun onResponse(call: Call<ChargingStationState>, response: Response<ChargingStationState>) {
                when(response.code()){
                    200->{
                        response.body()?.let {

                            completion(RESPONSE_STATUS.OKAY,it)
                        }
                    }
                }
            }
            override fun onFailure(call: Call<ChargingStationState>, t: Throwable) {

            }
        })
    }
}
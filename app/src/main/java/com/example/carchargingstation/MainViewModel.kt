package com.example.carchargingstation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carchargingstation.rpdatamodel.ChargingStationState
import com.example.carchargingstation.network.RetrofitManager
import com.example.carchargingstation.utils.Constants.TAG
import com.example.carchargingstation.utils.RESPONSE_STATUS

class MainViewModel: ViewModel() {
    private var _stationData= MutableLiveData<ChargingStationState>()
    val stationData: LiveData<ChargingStationState>
        get() =_stationData

    fun getSearchData( addr:String){
        Log.d(TAG, "MainViewModel -getHomeData() ")
        RetrofitManager.instance.callChargingStationData( addr=addr , 1 , 10, completion = {
                responseState, responseData ->
            when (responseState) {
                RESPONSE_STATUS.SUCCESS -> {
                    Log.d(TAG, "ViewModel - api 호출 성공: ")
                    _stationData.value=responseData
                }
                RESPONSE_STATUS.FAIL -> {
                    Log.d(TAG, "ViewModel - api 호출 실패: $responseData")
                }
                RESPONSE_STATUS.NO_CONTENT -> {
                    Log.d(TAG, "ViewModel - 검색 결과가 없습니다.")
                }
            }
        })
    }
}
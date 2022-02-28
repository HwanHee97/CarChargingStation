package com.example.carchargingstation.utils

object Constants {
    const val TAG:String="로그"
}
enum class FragmentType{
    SEARCH,
    MAP
}
enum class RESPONSE_STATUS{
    OKAY,
    FAIL,
    NO_CONTENT
}
object API{
    const val BASE_URL:String="http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList/"
    const val SERVICE_KEY:String=""

    const val SEARCH:String=""


}
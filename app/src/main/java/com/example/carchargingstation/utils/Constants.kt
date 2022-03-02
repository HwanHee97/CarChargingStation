package com.example.carchargingstation.utils

object Constants {
    const val TAG:String="로그"
}
enum class FragmentType{
    SEARCH,
    MAP
}
enum class RESPONSE_STATUS{
    SUCCESS,
    FAIL,
    NO_CONTENT
}
object API{
    const val BASE_URL:String="http://openapi.kepco.co.kr/service/EvInfoServiceV2/"
    const val SERVICE_KEY:String="1wgTD5xdEVUXM9p6lZj3YKT8rUBDAkMZ5Qmt4LIO28Kw88gd98PJdFbwrkTefD/kL9Jt7xGohDNAGNU2g2xySQ=="

    const val SEARCH:String="getEvSearchList"


}
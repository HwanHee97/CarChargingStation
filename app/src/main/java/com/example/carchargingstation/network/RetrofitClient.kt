package com.example.carchargingstation.network

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.carchargingstation.utils.API
import com.example.carchargingstation.utils.Constants.TAG
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import java.lang.Exception


object RetrofitClient {
    private var retrofitClient: Retrofit?=null

    fun getClient(baseUrl: String):Retrofit?{
        val client= OkHttpClient.Builder()

//        //로그를 찍기 위해 로깅인터셉터 설정
//        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
//            override fun log(message: String) {
//                Log.d(TAG, "RetrofitClient - log() called / message : $message")
//            }
//        })
//        //로깅 레벨 설정
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        client.addInterceptor(loggingInterceptor)

        //기본 파라미터 추가(서비스 키)
        val baseParameterInterceptor: Interceptor =(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                //오리지널 리퀘스트
                val originalRequest=chain.request()
                //쿼리 파라메터 추가하기
                val addedUrl=originalRequest.url.newBuilder().addQueryParameter("serviceKey", API.SERVICE_KEY).build()
                val finalRequest = originalRequest.newBuilder().url(addedUrl).method(originalRequest.method,originalRequest.body).build()
                val response: Response = chain.proceed(finalRequest)
                return response
            }
        })

        client.addInterceptor(baseParameterInterceptor)
        client.retryOnConnectionFailure(true)//네트워크 상황이 불안정할 때 Retry를 시도
        if (retrofitClient == null){
            retrofitClient=Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
                .client(client.build())
                .build()
        }
        return retrofitClient
    }
}
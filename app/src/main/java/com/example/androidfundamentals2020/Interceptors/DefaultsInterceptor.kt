package com.example.androidfundamentals2020.Interceptors

import com.example.androidfundamentals2020.BuildConfig
import com.example.androidfundamentals2020.R
import okhttp3.Interceptor
import okhttp3.Response

class DefaultsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder()
            .setQueryParameter("api_key", BuildConfig.API_KEY)
            .setQueryParameter("language", R.string.lang.toString())
            .build()
        val enrichedRequest = originalRequest.newBuilder().url(url).build()
        return chain.proceed(enrichedRequest)
    }
}

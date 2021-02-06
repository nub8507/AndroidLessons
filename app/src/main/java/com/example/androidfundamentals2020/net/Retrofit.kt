package com.example.androidfundamentals2020.net

import com.example.androidfundamentals2020.BuildConfig
import com.example.androidfundamentals2020.R
import com.example.androidfundamentals2020.interceptors.DefaultsInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit

object RetrofitModule {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(DefaultsInterceptor())
        .build()

    @Suppress("EXPERIMENTAL_API_USAGE")
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val movieApi: MovieApi = retrofit.create(MovieApi::class.java)
}

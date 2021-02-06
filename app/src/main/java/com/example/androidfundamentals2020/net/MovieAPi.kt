package com.example.androidfundamentals2020.net

import retrofit2.http.GET
import retrofit2.http.Path


interface MovieApi {

    @GET("configuration")
    suspend fun getConfiguration(): ApiConfig

    @GET("movie/now_playing?page=1")
    suspend fun getMovies(): Movies

    @GET("genre/movie/list")
    suspend fun getGenres(): Genres

    @GET("movie/{id}/credits")
    suspend fun getCredits(@Path("id") movieId: Int): Credits

    @GET("movie/{movieID}")
    suspend fun getDetails(@Path("movieID") movieId: Int): MovieJson
}




package com.example.androidfundamentals2020.data

import com.example.androidfundamentals2020.net.Movies
import com.example.androidfundamentals2020.net.RetrofitModule.movieApi

suspend fun loadBaseUrl(): String {
    return movieApi.getConfiguration().images?.secureBaseUrl?.dropLast(1) ?: ""
}

suspend fun loadGenres(): Map<Int, Genre> {
    return movieApi.getGenres().genres.map { it.id to Genre(it.id, it.name) }.toMap()
}

suspend fun loadMoviesList(): Movies {
    return movieApi.getMovies()
}

suspend fun getActors(movieId: Int): List<Actor> {
    return movieApi.getCredits(movieId).cast.map {
        Actor(
            it.castID ?: 0,
            it.name ?: "",
            it.profilePath ?: ""
        )
    }.toList()
}

suspend fun loadDetails(movieId: Int): Int? {
    return movieApi.getDetails(movieId).runtime
}

suspend fun loadMovies(): List<Movie>? {

    val currBaseUrl = loadBaseUrl()

    val genres = loadGenres()

    return loadMoviesList().results?.map {
        Movie(
            id = it?.id ?: 0,
            title = it?.title ?: "",
            overview = it?.overview ?: "",
            poster = "$currBaseUrl/original/${it?.posterPath}",
            backdrop = "$currBaseUrl/original/${it?.backdropPath}",
            ratings = it?.voteAverage ?: 0 / 2f,
            numberOfRatings = it?.voteCount ?: 0,
            minimumAge = if (it?.adult == true) 16 else 13,
            runtime = loadDetails(it?.id ?: 0) ?: 0,
            genres = it?.genreIds?.map { id -> genres.getOrDefault(id, Genre(0, "")) }
                ?.toList() as List<Genre>,
            actors = getActors(
                it?.id ?: 0
            ).map { actor -> actor.copy(picture = "$currBaseUrl/original/${actor.picture}") }
        )
    }
}

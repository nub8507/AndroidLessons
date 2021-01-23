package com.example.androidfundamentals2020.data

import com.example.androidfundamentals2020.db.ActorDbEntity
import com.example.androidfundamentals2020.db.DbMovieEntity
import com.example.androidfundamentals2020.db.GenreDbEntity
import com.example.androidfundamentals2020.net.Movies
import com.example.androidfundamentals2020.net.RetrofitModule.movieApi

suspend fun loadBaseUrl(): String {
    return movieApi.getConfiguration().images?.secureBaseUrl?.dropLast(1) ?: ""
}

suspend fun loadGenres(): Map<Int, GenreDbEntity> {
    return movieApi.getGenres().genres.map { it.id to GenreDbEntity((it.id).toLong(), it.name) }.toMap()
}

suspend fun loadMoviesList(): Movies {
    return movieApi.getMovies()
}

suspend fun getActors(movieId: Int): List<ActorDbEntity> {
    return movieApi.getCredits(movieId).cast.map {
        ActorDbEntity(
            (it.castID ?: 0).toLong(),
            it.name,
            it.profilePath ?: ""
        )
    }.toList()
}

suspend fun loadDetails(movieId: Int): Int? {
    return movieApi.getDetails(movieId).runtime
}

suspend fun loadMovies(): List<DbMovieEntity>? {

    val currBaseUrl = loadBaseUrl()

    val genres = loadGenres()

    return loadMoviesList().results?.map {
        DbMovieEntity(
            id = (it?.id ?: 0).toLong(),
            title = it?.title ?: "",
            overview = it?.overview ?: "",
            poster = "$currBaseUrl/original/${it?.posterPath}",
            backdrop = "$currBaseUrl/original/${it?.backdropPath}",
            ratings = it?.voteAverage ?: 0 / 2f,
            numberOfRatings = it?.voteCount ?: 0,
            minimumAge = if (it?.adult == true) 16 else 13,
            runtime = loadDetails(it?.id ?: 0) ?: 0,
            genres = it?.genreIds?.map { id -> genres.getOrDefault(id, GenreDbEntity(0, "")) }
                ?.toList() as List<GenreDbEntity>,
            actors = getActors(
                it.id ?: 0
            ).map { actor -> actor.copy(picture = "$currBaseUrl/original/${actor.picture}") }
        )
    }
}

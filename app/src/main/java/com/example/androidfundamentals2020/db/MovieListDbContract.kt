package com.example.androidfundamentals2020.db

import android.provider.BaseColumns

object MovieListDbContract {

    const val DATABASE_NAME = "Movies.db"

    object Movies {
        const val TABLE_NAME = "Movies"

        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_OVERVIEW = "overview"
        const val COLUMN_NAME_POSTER = "poster"
        const val COLUMN_NAME_BACKDROP = "backdrop"
        const val COLUMN_NAME_RATINGS = "ratings"
        const val COLUMN_NAME_NUMBEROFRATINGS = "numberOfRatings"
        const val COLUMN_NAME_MINIMUMAGE = "minimumAge"
        const val COLUMN_NAME_RUNTIME = "runtime"

    }

    object Actors {
        const val TABLE_NAME = "Actors"

        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_ID_ID = "id"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_PICTURE = "picture"
        const val COLUMN_NAME_MOVIE_ID = "movie_id"

    }

    object Genres {
        const val TABLE_NAME = "Genres"

        const val COLUMN_NAME_ID = BaseColumns._ID
        const val COLUMN_NAME_ID_ID = "id"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_MOVIE_ID = "movie_id"

    }
}

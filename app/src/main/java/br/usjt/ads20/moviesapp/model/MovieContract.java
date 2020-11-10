package br.usjt.ads20.moviesapp.model;

import android.provider.BaseColumns;

public final class MovieContract {
    public static abstract class MovieEntry implements BaseColumns {
        public static final String TABLE_NAME = "movie";
        public static final String COLUMN_NAME_ID_MOVIE = "idMovie";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_POPULARITY = "popularity";
        public static final String COLUMN_NAME_RELEASE_DATE = "releaseDate";
        public static final String COLUMN_NAME_POSTER_PATH = "posterPath";
        public static final String COLUMN_NAME_BACKDROP_PATH = "backdropPath";
        public static final String COLUMN_NAME_CATEGORY = "idCategory";
        public static final String COLUMN_NAME_CATEGORY_NAME = "categoryName";
        public static final String COLUMN_NAME_DIRECTOR = "director";
        public static final String COLUMN_NAME_IMAGE_POSTER = "imagePoster";
        public static final String COLUMN_NAME_IMAGE_BACKDROP = "imageBackdrop";
    }
}

package br.usjt.ads20.moviesapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.ads20.moviesapp.model.MovieContract.*;
public class MovieDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;

    public  static final String DATABASE_NAME = "movie.db";

    public static final String SQL_CREATE_MOVIE =
            "CREATE TABLE " + MovieEntry.TABLE_NAME + " ( " +
                    MovieEntry._ID + " INTEGER PRIMARY KEY," +
                    MovieEntry.COLUMN_NAME_ID_MOVIE + " INTEGER," +
                    MovieEntry.COLUMN_NAME_TITLE + " TEXT," +
                    MovieEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
                    MovieEntry.COLUMN_NAME_DIRECTOR + " TEXT," +
                    MovieEntry.COLUMN_NAME_RELEASE_DATE + " INTEGER," +
                    MovieEntry.COLUMN_NAME_POPULARITY + " REAL," +
                    MovieEntry.COLUMN_NAME_POSTER_PATH + " TEXT," +
                    MovieEntry.COLUMN_NAME_BACKDROP_PATH + " TEXT," +
                    MovieEntry.COLUMN_NAME_CATEGORY_NAME + " TEXT," +
                    MovieEntry.COLUMN_NAME_CATEGORY + " INTEGER," +
                    MovieEntry.COLUMN_NAME_IMAGE_BACKDROP + " BLOB," +
                    MovieEntry.COLUMN_NAME_IMAGE_POSTER + " BLOB)";

    public static final String SQL_DROP_MOVIE =
            "DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME;

    public  MovieDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_MOVIE);
        db.execSQL(SQL_CREATE_MOVIE);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, newVersion, oldVersion);
    }
}

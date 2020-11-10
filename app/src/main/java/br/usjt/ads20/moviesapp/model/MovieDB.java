package br.usjt.ads20.moviesapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MovieDB {
    MovieDBHelper movieDBHelper;

    public MovieDB (Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    public void saveMovies (ArrayList<Movie> movies) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        db.delete(MovieContract.MovieEntry.TABLE_NAME, null, null);

        for (Movie movie: movies) {
            ContentValues values = new ContentValues();
            values.put(MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE, movie.getId());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_TITLE, movie.getTitle());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_DESCRIPTION, movie.getDescription());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_POPULARITY, movie.getPopularity());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_DIRECTOR, movie.getDirector());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_CATEGORY_NAME, movie.getCategory().getName());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_CATEGORY, movie.getCategory().getId());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_POSTER_PATH, movie.getPosterPath());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_BACKDROP_PATH, movie.getBackdropPath());
            values.put(MovieContract.MovieEntry.COLUMN_NAME_RELEASE_DATE,
                    String.format("%tY-%tm-%td", movie.getReleaseDate(), movie.getReleaseDate(), movie.getReleaseDate()));

            db.insert(MovieContract.MovieEntry.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<Movie> searchMovies () {
        ArrayList<Movie> movies = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        SQLiteDatabase db = movieDBHelper.getWritableDatabase();

        String[] columns = {
                MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE,
                MovieContract.MovieEntry.COLUMN_NAME_TITLE,
                MovieContract.MovieEntry.COLUMN_NAME_DESCRIPTION,
                MovieContract.MovieEntry.COLUMN_NAME_POPULARITY,
                MovieContract.MovieEntry.COLUMN_NAME_DIRECTOR,
                MovieContract.MovieEntry.COLUMN_NAME_CATEGORY_NAME,
                MovieContract.MovieEntry.COLUMN_NAME_CATEGORY,
                MovieContract.MovieEntry.COLUMN_NAME_POSTER_PATH,
                MovieContract.MovieEntry.COLUMN_NAME_BACKDROP_PATH,
                MovieContract.MovieEntry.COLUMN_NAME_RELEASE_DATE
        };

        String where = null;

        String[] conditions = null;

        String order = MovieContract.MovieEntry.COLUMN_NAME_TITLE;

        Cursor cursor = db.query(MovieContract.MovieEntry.TABLE_NAME, columns, where, conditions, order, null, null);

        while (cursor.moveToNext()) {
            Movie movie = new Movie();
            movie.setId(cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE)));
            movie.setTitle(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_TITLE)));
            movie.setDescription(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_DESCRIPTION)));
            movie.setPopularity(cursor.getDouble(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_POPULARITY)));
            movie.setDirector(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_DIRECTOR)));
            movie.setPosterPath(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_POSTER_PATH)));
            movie.setBackdropPath(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_BACKDROP_PATH)));
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_CATEGORY)));
            category.setName(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_CATEGORY_NAME)));
            movie.setCategory(category);
            Date releaseDate = null;
            try {
                releaseDate = format.parse(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_RELEASE_DATE)));
                movie.setReleaseDate(releaseDate);
            } catch (ParseException e) {
                movie.setReleaseDate(new Date());
                e.printStackTrace();
            }
            movies.add(movie);
        }
        cursor.close();
        db.close();
        return movies;
    }

    public void updateBackdrop(int idMovie, Bitmap img){
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();

        String select = MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE + "=?";
        String[] selectionArgs = new String[1];

        selectionArgs[0] = ""+idMovie;
        ContentValues values = new ContentValues();
        values.put(MovieContract.MovieEntry.COLUMN_NAME_IMAGE_BACKDROP, getPictureOfArray(img));
        db.update(MovieContract.MovieEntry.TABLE_NAME, values, select, selectionArgs);
    }
    
    public void updatePosters (ArrayList<Poster> posters) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();

        String select = MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE + "=?";

        String[] selectionArgs = new String[1];

        for (Poster poster:posters) {
            selectionArgs[0] = ""+poster.getId();

            ContentValues values = new ContentValues();

            values.put(MovieContract.MovieEntry.COLUMN_NAME_IMAGE_POSTER, getPictureOfArray(poster.getPoster()));

            db.update(MovieContract.MovieEntry.TABLE_NAME, values, select, selectionArgs);
        }
    }

    public Bitmap searchBackdrop(int idMovie){
        Bitmap img = null;
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        String[] columns = {
                MovieContract.MovieEntry.COLUMN_NAME_IMAGE_BACKDROP
        };
        String select = MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE + "=?";
        String[] selectionArgs = new String[1];

        selectionArgs[0] = ""+idMovie;

        Cursor c = db.query(MovieContract.MovieEntry.TABLE_NAME, columns, select, selectionArgs, null, null, null);
        if (c.moveToNext()){
            img = getBitmapFromByte(c.getBlob(c.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_IMAGE_BACKDROP)));
        }
        c.close();
        db.close();

        return img;
    }
    
    public ArrayList<Poster> searchPosters () {
        ArrayList<Poster> posters = new ArrayList<>();

        SQLiteDatabase db = movieDBHelper.getWritableDatabase();

        String[] columns = {
                MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE,
                MovieContract.MovieEntry.COLUMN_NAME_TITLE,
                MovieContract.MovieEntry.COLUMN_NAME_IMAGE_POSTER
        };

        String order = null;
        String where = null;
        String[] conditions = null;

        Cursor cursor = db.query(MovieContract.MovieEntry.TABLE_NAME, columns, where, conditions, order, null, null);

        while (cursor.moveToNext()) {
            Poster poster = new Poster();
            poster.setId(cursor.getInt((cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_ID_MOVIE))));
            poster.setTitle(cursor.getString(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_TITLE)));
            poster.setPoster(getBitmapFromByte(cursor.getBlob(cursor.getColumnIndex(MovieContract.MovieEntry.COLUMN_NAME_IMAGE_POSTER))));

            posters.add(poster);
        }
        cursor.close();
        db.close();

        return posters;
    }

    private  Bitmap getBitmapFromByte (byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    private byte[] getPictureOfArray (Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

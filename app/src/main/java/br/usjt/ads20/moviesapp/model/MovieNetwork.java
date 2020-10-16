package br.usjt.ads20.moviesapp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieNetwork {

    public static ArrayList<Movie> searchMovies(String url) throws IOException {
        ArrayList<Movie> movies = new ArrayList<>();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        OkHttpClient client = new OkHttpClient();

        Log.d("MovieNetwork.buscarMovies:url", url);

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        Log.i(json, "searchMovies: ");

        try {
            JSONObject jsonResponse = new JSONObject(json);
            JSONArray list = jsonResponse.getJSONArray("results");
            for(int i = 0; i < list.length(); i++){
                Movie movie = new Movie();
                JSONObject item = (JSONObject) list.get(i);

                movie.setId(item.getInt("id"));
                movie.setTitle(item.getString("title"));
                movie.setBackdropPath(item.getString("backdrop_path"));
                movie.setDescription(item.getString("overview"));
                movie.setPosterPath(item.getString("poster_path"));
                movie.setPopularity(item.getDouble("popularity"));
                movie.setDirector("Unknown");
                try {
                    movie.setReleaseDate(formatter.parse(item.getString("release_date")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                JSONArray categories = item.getJSONArray("genre_ids");
                Category category = new Category();
                category.setId(categories.getInt(0));
                movie.setCategory(category);
                movies.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return movies;
    }

    public static ArrayList<Category> searchCategories(String url) throws IOException {
        ArrayList<Category> categories = new ArrayList<>();

        OkHttpClient client = new OkHttpClient();

        Log.d("MovieNetwork.searchCategories:url", url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject jsonReturn = new JSONObject(json);
            
            System.out.println(jsonReturn);
            
            JSONArray list = jsonReturn.getJSONArray("genres");
            for(int i = 0; i < list.length(); i++){
                Category category = new Category();
                JSONObject item = (JSONObject) list.get(i);
                category.setId(item.getInt("id"));
                category.setName(item.getString("name"));
                categories.add(category);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return categories;
    }

    public static String searchDirectors(String url) throws IOException {
        String director = "";
        ArrayList<String> directors = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();

        Log.d("MovieNetwork.searchDirectors:url", url);
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        try {
            JSONObject jsonReturn = new JSONObject(json);
            JSONArray list = jsonReturn.getJSONArray("crew");
            for(int i = 0; i < list.length(); i++) {
                JSONObject item = (JSONObject)list.get(i);
                //System.out.println(item);
                if (item.getString("job").equals("Director")) {
                    directors.add(item.getString("name"));
                }
            }
            if(directors.size()==1){
                director = directors.get(0);
            } else if(directors.size()==2){
                director = directors.get(0)+" & "+directors.get(1);
            } else if(directors.size()>2){
                for(int j = 0; j < directors.size(); j++){
                    if(j == directors.size()-1){
                        director += " & "+directors.get(j);
                    } else {
                        director += ", "+directors.get(j);
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return director;
    }

    public static Bitmap searchImages(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Bitmap img = null;

        Log.d("MovieNetwork.searchImages:url", url);
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        InputStream is = response.body().byteStream();

        img = BitmapFactory.decodeStream(is);

        is.close();

        return img;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager manager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return manager.getActiveNetworkInfo() != null &&
                manager.getActiveNetworkInfo().isConnected();
    }
}
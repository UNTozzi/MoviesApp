package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads20.moviesapp.model.Category;
import br.usjt.ads20.moviesapp.model.Data;
import br.usjt.ads20.moviesapp.model.Movie;
import br.usjt.ads20.moviesapp.model.MovieDB;
import br.usjt.ads20.moviesapp.model.MovieNetwork;
import br.usjt.ads20.moviesapp.model.Poster;

public class MainActivity extends AppCompatActivity {
    private EditText txtName;
    private ProgressBar progressBar;
    public  static final String NAME = "br.usjt.ads20.moviesapp.name";
    public  static final String MOVIES = "br.usjt.ads20.moviesapp.movies";
    private String url = "https://api.themoviedb.org/3/movie/popular?" +
            "language=%s-%s&page=1&api_key=";
    private String imgUrl = "https://image.tmdb.org/t/p/w300";
    private String genUrl = "https://api.themoviedb.org/3/genre/movie/list?" +
            "language=%s-%s&api_key=";
    private String dirUrl = "https://api.themoviedb.org/3/movie/%s/credits?api_key=";
    private Context context;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText)findViewById(R.id.searchQueue);
        progressBar = (ProgressBar)findViewById(R.id.progressBarMain);
        context = this;
    }

    public void searchMovies(View view) {
        if (MovieNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            String language = this.getResources().getString(R.string.language);
            String country = this.getResources().getString(R.string.country);
            new DownloadJsonMovies().execute(String.format(url,language,country) + getKey(),
                    String.format(genUrl,language,country) + getKey(),
                    dirUrl + getKey());
        } else {
            String msg = this.getResources().getString(R.string.networkError);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
            progressBar.setVisibility(View.VISIBLE);
            new LoadMovieDB().execute();
        }
    }

    private class DownloadJsonMovies extends AsyncTask<String, Void, ArrayList<Movie>>{

        @Override
        protected ArrayList<Movie> doInBackground(String... strings) {
            ArrayList<Category> categories = new ArrayList<>();
            ArrayList<Movie> movies = new ArrayList<>();
            ArrayList<Poster> images = new ArrayList<>();
            try {
                categories = MovieNetwork.searchCategories(strings[1]);
                movies = MovieNetwork.searchMovies(strings[0]);
                for(Movie movie: movies){
                    int position = categories.indexOf(movie.getCategory());
                    if(position >= 0){
                        movie.setCategory(categories.get(position));
                    }
                    String urlDir2 = String.format(strings[2],movie.getId());
                    String director = MovieNetwork.searchDirectors(urlDir2);
                    movie.setDirector(director);
                    String poster = movie.getPosterPath();
                    Bitmap img = MovieNetwork.searchImages(imgUrl + poster);
                    Poster p = new Poster();
                    p.setId(movie.getId());
                    p.setTitle(movie.getTitle());
                    p.setPoster(img);
                    images.add(p);
                }
                Data.setImages(images);
                MovieDB movieDB = new MovieDB(context);
                movieDB.saveMovies(movies);
                movieDB.updatePosters(images);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return movies;
        }

        protected void onPostExecute(ArrayList<Movie> movies){
            Intent intent = new Intent(context, ListMoviesActivity.class);

            MovieDB db = new MovieDB(context);
            movies = db.searchMovies();

            String name = txtName.getText().toString();
            intent.putExtra(NAME, name);
            intent.putExtra(MOVIES, movies);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
    }

    private class LoadMovieDB extends AsyncTask<String, Void, ArrayList<Movie>> {

        @Override
        protected ArrayList<Movie> doInBackground(String... strings) {
            MovieDB db = new MovieDB(context);

            ArrayList<Movie> movies = db.searchMovies();
            ArrayList<Poster> posters = db.searchPosters();
            Data.setImages(posters);


            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            Intent intent = new Intent(context, ListMoviesActivity.class);

            MovieDB db = new MovieDB(context);
            movies = db.searchMovies();

            String name = txtName.getText().toString();
            intent.putExtra(NAME, name);
            intent.putExtra(MOVIES, movies);
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
    }

    private String getKey () {
        return "cf13706ef62004b69b751e300efa91ce";
    }
}
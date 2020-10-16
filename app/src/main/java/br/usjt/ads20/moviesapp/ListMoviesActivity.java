package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ads20.moviesapp.model.Data;
import br.usjt.ads20.moviesapp.model.Movie;
import br.usjt.ads20.moviesapp.model.MovieNetwork;
import br.usjt.ads20.moviesapp.model.Poster;

import static br.usjt.ads20.moviesapp.model.Data.searchMovies;

public class ListMoviesActivity extends AppCompatActivity {
    public static final String MOVIE = "br.usjt.ads20.moviesapp.movie";
    Movie[] moviesList;
    Poster[] posters;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        activity = this;

        final Intent intent = getIntent();

        String key = intent.getStringExtra(MainActivity.NAME);
        ArrayList<Movie> movies = (ArrayList<Movie>) intent.getSerializableExtra(MainActivity.MOVIES);
        Data.setMovies(movies);

        moviesList = searchMovies(key);
        posters = Data.searchPosters(key);

        BaseAdapter adapter = new MovieAdapter(this, moviesList, posters);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Intent itemClickedIntent = new Intent(activity, MovieDetailActivity.class);
                itemClickedIntent.putExtra(MOVIE, moviesList[index]);
                startActivity(itemClickedIntent);
            }
        });
    }


}
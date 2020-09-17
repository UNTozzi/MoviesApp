package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import br.usjt.ads20.moviesapp.model.Movie;

import static br.usjt.ads20.moviesapp.model.Data.searchMovies;

public class ListMoviesActivity extends AppCompatActivity {
    public static final String DESCRIPTION = "br.usjt.ads20.moviesapp.description";
    Movie[] movies;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);
        activity = this;
        final Intent intent = getIntent();
        String key = intent.getStringExtra(MainActivity.NAME);
        movies = searchMovies(key);
        BaseAdapter adapter = new MovieAdapter(this, movies);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Intent itemClickedIntent = new Intent(activity, MovieDetailActivity.class);
                itemClickedIntent.putExtra(DESCRIPTION, movies[index].getTitle());
                startActivity(itemClickedIntent);
            }
        });
    }


}
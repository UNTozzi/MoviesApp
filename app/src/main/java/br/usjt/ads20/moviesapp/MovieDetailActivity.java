package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ads20.moviesapp.model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView title, category, director, releaseDate, popularity, description;
    private ImageView backdrop;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView)findViewById(R.id.txtTitle);
        description = (TextView)findViewById(R.id.txtDescription);
        category = (TextView)findViewById(R.id.txtCategory);
        director = (TextView)findViewById(R.id.txtDirector);
        releaseDate = (TextView)findViewById(R.id.txtRelease);
        popularity = (TextView)findViewById(R.id.txtPopularity);

        Intent intent = getIntent();

        movie = (Movie)intent.getSerializableExtra(ListMoviesActivity.MOVIE);
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        category.setText(movie.getCategory().getName());
        director.setText(movie.getDirector());
        releaseDate.setText(String.format("%td-%tb-%ty", movie.getReleaseDate(), movie.getReleaseDate(), movie.getReleaseDate()));
        popularity.setText(String.format("%.1f", movie.getPopularity()));

    }
}
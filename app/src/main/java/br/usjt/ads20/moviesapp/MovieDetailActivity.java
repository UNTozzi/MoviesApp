package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import br.usjt.ads20.moviesapp.model.Movie;
import br.usjt.ads20.moviesapp.model.MovieNetwork;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView title, category, director, releaseDate, popularity, description;
    private ImageView backdrop;
    private ProgressBar progressBar;
    private Movie movie;
    private String imgUrl = "https://image.tmdb.org/t/p/w780";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        backdrop = (ImageView)findViewById(R.id.backdropView);

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
        progressBar = (ProgressBar)findViewById(R.id.progressBarDetail);
        if (MovieNetwork.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            new DownloadBackdrop().execute(imgUrl + movie.getBackdropPath());
        } else {
            String msg = this.getResources().getString(R.string.networkError);
            Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private class DownloadBackdrop extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap img = null;
            try {
                img = MovieNetwork.searchImages(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return img;
        }

        protected void onPostExecute(Bitmap img) {
            backdrop.setImageBitmap(img);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
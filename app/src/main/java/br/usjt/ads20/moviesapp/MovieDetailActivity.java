package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name = (TextView)findViewById(R.id.selected_movie);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra(ListMoviesActivity.DESCRIPTION));
    }
}
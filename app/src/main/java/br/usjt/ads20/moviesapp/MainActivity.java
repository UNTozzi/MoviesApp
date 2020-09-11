package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtName;
    public  static final String NAME = "br.usjt.ads20.moviesapp.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = (EditText)findViewById(R.id.search_movie);
    }

    public void searchMovies(View view) {
        String name = txtName.getText().toString();
        Intent intent = new Intent(this, ListMoviesActivity.class);
        intent.putExtra(NAME, name);
        startActivity(intent);

    }
}
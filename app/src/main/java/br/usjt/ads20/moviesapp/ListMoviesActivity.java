package br.usjt.ads20.moviesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMoviesActivity extends AppCompatActivity {
    public static final String DESCRIPTION = "br.usjt.ads20.moviesapp.description";
    ArrayList<String> list;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);
        activity = this;
        final Intent intent = getIntent();
        String key = intent.getStringExtra(MainActivity.NAME);
        list = searchMovies(key);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Intent itemClickedIntent = new Intent(activity, MovieDetailActivity.class);
                itemClickedIntent.putExtra(DESCRIPTION, list.get(index));
                startActivity(itemClickedIntent);
            }
        });
    }

    private ArrayList<String> searchMovies(String key) {
        ArrayList<String> list = makeMoviesList();

        if (key == null || key.length() == 0) return list;
        else {
            ArrayList<String> filter = new ArrayList<>();
            for (String name : list) {
                if (name.toUpperCase().contains(key.toUpperCase())) {
                    filter.add(name);
                }
            }
            return filter;
        }
    }

    private ArrayList<String> makeMoviesList() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Aventura: Guerra nas Estrelas (1977)");
        list.add("Fantasia: O Senhor dos Anéis: O Retorno do Rei");
        list.add("Ação: Matrix");
        list.add("Aventura: De Volta para o Futuro");
        list.add("Ficção Científica: Jornada nas Estrelas");
        list.add("Aventura: Os Goonies");
        list.add("Ficção Científica: Blade Runner, o Caçador de Androides");
        list.add("Suspense: Allien");
        list.add("Drama: Platoon");
        list.add("Ação: Os Vingadores");
        list.add("Thriller: Pulp Fiction");
        list.add("Aventura: Os Caçadores da Arca Perdida");
        list.add("Terror: It - A coisa");
        list.add("Terror: Psicose");
        list.add("Comédia: Monty Python em Busca do Cálice Sagrado");
        list.add("Terror: Os Garotos Perdidos");
        list.add("Suspense: Seven, os Sete Pecados Capitais");
        list.add("Ação: Kill Bill");
        list.add("Fantasia: Alice no País das Maravilhas");
        list.add("Anime: Akira");
        list.add("Terror: Hereditário");

        return list;
    }
}
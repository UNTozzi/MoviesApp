package br.usjt.ads20.moviesapp.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Data {
    private static ArrayList<Movie> movies;
    private static ArrayList<Poster> images;

    public static ArrayList<Poster> getImages() {
        return images;
    }

    public static void setImages(ArrayList<Poster> images) {
        Data.images = images;
    }

    public static void setMovies(ArrayList<Movie> pMovies){
        movies = pMovies;
    }


    public static Movie[] searchMovies(String key) {
        ArrayList<Movie> list = movies;
        
        ArrayList<Movie> filter;

        if (key == null || key.length() == 0) {
            filter = list;
        }
        else {
            filter = new ArrayList<>();
            for (Movie movie : list) {
                String name = movie.getTitle();
                if (name.toUpperCase().contains(key.toUpperCase())) {
                    filter.add(movie);
                }
            }
        }
        Movie[] movies = filter.toArray(new Movie[0]);
        Arrays.sort(movies);
        return movies;
    }

    public static Poster[] searchPosters(String key){
        ArrayList<Poster> list = images;
        ArrayList<Poster> filter;
        Poster[] posters;
        if(key == null || key.length() == 0){
            filter = list;
        } else {
            filter = new ArrayList<>();
            for(Poster poster: list){
                String name = poster.getTitle();
                if(name.toUpperCase().contains(key.toUpperCase())){
                    filter.add(poster);
                }
            }
        }
        posters = filter.toArray(new Poster[0]);
        Arrays.sort(posters);
        return posters;
    }

    public static ArrayList<Category> createCategory() {
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(1, "Não Cadastrado"));
        list.add(new Category(28, "Ação"));
        list.add(new Category(12, "Aventura"));
        list.add(new Category(16, "Animação"));
        list.add(new Category(35, "Comédia"));
        list.add(new Category(80, "Crime"));
        list.add(new Category(99, "Documentário"));
        list.add(new Category(18, "Drama"));
        list.add(new Category(10751, "Família"));
        list.add(new Category(14, "Fantasia"));
        list.add(new Category(36, "História"));
        list.add(new Category(27, "Horror"));
        list.add(new Category(10402, "Musical"));
        list.add(new Category(9648, "Mistério"));
        list.add(new Category(10749, "Romance"));
        list.add(new Category(878, "Ficção Científica"));
        list.add(new Category(10770, "Movie para TV"));
        list.add(new Category(53, "Suspense"));
        list.add(new Category(10752, "Guerra"));
        list.add(new Category(37, "Western"));

        return list;
    }

}

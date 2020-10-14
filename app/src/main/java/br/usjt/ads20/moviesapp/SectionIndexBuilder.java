package br.usjt.ads20.moviesapp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

import br.usjt.ads20.moviesapp.model.Movie;

public class SectionIndexBuilder {

    public static Object[] buildSectionHeaders(Movie[] movies) {
        ArrayList<String> results = new ArrayList<>();

        TreeSet<String> used = new TreeSet<>();
        if (movies != null) {
            for (Movie movie : movies) {
                String letter = movie.getTitle().substring(0, 1);
                if (!used.contains(letter)) results.add(movie.getTitle().substring(0, 1));
                used.add(letter);
            }
        }
        return results.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Movie[] movies) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if (movies != null) {
            for (int i = 0; i < movies.length; i++) {
                String letter = movies[i].getTitle().substring(0, 1);
                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                    results.put(section, i);
                }
            }
        }

        return results;
    }

    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Movie[] movies) {
        Hashtable<Integer, Integer> results = new Hashtable<>();
        TreeSet<String> used = new TreeSet<>();
        int section = -1;

        if (movies != null) {
            for (int i = 0; i < movies.length; i++) {
                String letter = movies[i].getTitle().substring(0, 1);
                if (!used.contains(letter)) {
                    section++;
                    used.add(letter);
                }
                results.put(i, section);
            }
        }

        return results;
    }
}

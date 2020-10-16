package br.usjt.ads20.moviesapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

import br.usjt.ads20.moviesapp.model.Movie;
import br.usjt.ads20.moviesapp.model.Poster;

public class MovieAdapter extends BaseAdapter implements SectionIndexer {
    private Movie[] movies;
    Poster[] images;
    private Context context;
    private Object[] sectionHeaders;
    private Hashtable<Integer, Integer> sectionForPositionMap;
    private Hashtable<Integer, Integer> positionToSectionMap;

    public MovieAdapter(Context context, Movie[] movies, Poster[] images) {
        this.movies = movies;
        this.images = images;
        this.context = context;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(movies);
        positionToSectionMap = SectionIndexBuilder.buildPositionForSectionMap(movies);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(movies);

    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < movies.length) return movies[index];
        return null;
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.movie_row, viewGroup, false);

            ImageView moviePoster = (ImageView) view.findViewById(R.id.movie_poster);
            TextView movieName = (TextView) view.findViewById(R.id.movie_name);
            TextView detail1Movie = (TextView) view.findViewById(R.id.detail1Movie);
            TextView detail2Movie = (TextView) view.findViewById(R.id.detail2Movie);
            TextView detail3Movie = (TextView) view.findViewById(R.id.detail3Movie);
            TextView detail4Movie = (TextView) view.findViewById(R.id.detail4Movie);
            ViewHolder viewHolder = new ViewHolder(moviePoster, movieName, detail1Movie,
                    detail2Movie, detail3Movie, detail4Movie);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder)view.getTag();
        viewHolder.getMoviePoster().setImageBitmap(images[index].getPoster());
        viewHolder.getMovieName().setText(movies[index].getTitle());
        //Locale locale = new Locale("pt", "BR");
        String lblCat = context.getResources().getString(R.string.lblCategory);
        String lblDir = context.getResources().getString(R.string.lblDirector);
        String lblRel = context.getResources().getString(R.string.lblRelease);
        String lblPop = context.getResources().getString(R.string.lblPopularity);
        viewHolder.getDetail1Movie().setText(String.format("%s: %s", lblCat, movies[index].getCategory().getName()));
        viewHolder.getDetail2Movie().setText(String.format("%s: %s", lblDir, movies[index].getDirector()));
        viewHolder.getDetail3Movie().setText(String.format("%s: %td-%tb-%ty", lblRel,
                movies[index].getReleaseDate(), movies[index].getReleaseDate(),
                movies[index].getReleaseDate()));
        viewHolder.getDetail4Movie().setText(String.format("%s: %.1f", lblPop, movies[index].getPopularity()));

        return view;
    }

    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int i) {
        return positionToSectionMap.get(i).intValue();
    }

    @Override
    public int getSectionForPosition(int i) {
        return sectionForPositionMap.get(i).intValue();
    }
}

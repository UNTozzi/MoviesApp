package br.usjt.ads20.moviesapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ads20.moviesapp.model.Movie;

public class MovieAdapter extends BaseAdapter {
    private Movie[] movies;
    private Context context;

    public MovieAdapter(Context context, Movie[] movies) {
        this.movies = movies;
        this.context = context;
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
            TextView movieDetail = (TextView) view.findViewById(R.id.movie_detail);

            view.setTag(new ViewHolder(moviePoster, movieName, movieDetail));
        }

        Drawable drawable = Util.getDrawable(context, movies[index].getPosterPath().substring(0, movies[index].getPosterPath().length()-4).toLowerCase());

        ViewHolder holder = (ViewHolder)view.getTag();
        
        holder.getMoviePoster().setImageDrawable(drawable);
        holder.getMovieName().setText(movies[index].getTitle());
        holder.getMovieDetail().setText(String.format("%s - Directed by: %s", movies[index].getCategory().getName(), movies[index].getDirector()));


        return view;
    }
}

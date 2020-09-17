package br.usjt.ads20.moviesapp;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private ImageView moviePoster;
    private TextView movieName, movieDetail;

    public ImageView getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(ImageView moviePoster) {
        this.moviePoster = moviePoster;
    }

    public TextView getMovieName() {
        return movieName;
    }

    public void setMovieName(TextView movieName) {
        this.movieName = movieName;
    }

    public TextView getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(TextView movieDetail) {
        this.movieDetail = movieDetail;
    }

    public ViewHolder(ImageView moviePoster, TextView movieName, TextView movieDetail) {
        this.moviePoster = moviePoster;
        this.movieName = movieName;
        this.movieDetail = movieDetail;
    }
}

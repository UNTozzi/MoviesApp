package br.usjt.ads20.moviesapp;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewHolder {
    private ImageView moviePoster;
    private TextView movieName, detail1Movie, detail2Movie, detail3Movie, detail4Movie;

    public ImageView getMoviePoster() {
        return moviePoster;
    }


    public void setMoviePoster(ImageView moviePoster) {
        this.moviePoster = moviePoster;
    }

    public TextView getDetail1Movie() {
        return detail1Movie;
    }
    
    public TextView getMovieName() {
        return movieName;
    }
    
    public void setMovieName(TextView movieName) {
        this.movieName = movieName;
    }
    
    public void setDetail1Movie(TextView detail1Movie) {
        this.detail1Movie = detail1Movie;
    }

    public TextView getDetail2Movie() {
        return detail2Movie;
    }

    public void setDetail2Movie(TextView detail2Movie) {
        this.detail2Movie = detail2Movie;
    }

    public TextView getDetail3Movie() {
        return detail3Movie;
    }

    public void setDetail3Movie(TextView detail3Movie) {
        this.detail3Movie = detail3Movie;
    }

    public TextView getDetail4Movie() {
        return detail4Movie;
    }

    public void setDetail4Movie(TextView detail4Movie) {
        this.detail4Movie = detail4Movie;
    }

    public ViewHolder(ImageView moviePoster, TextView movieName, TextView detail1Movie, TextView detail2Movie, TextView detail3Movie, TextView detail4Movie) {
        this.moviePoster = moviePoster;
        this.movieName = movieName;
        this.detail1Movie = detail1Movie;
        this.detail2Movie = detail2Movie;
        this.detail3Movie = detail3Movie;
        this.detail4Movie = detail4Movie;

    }
}

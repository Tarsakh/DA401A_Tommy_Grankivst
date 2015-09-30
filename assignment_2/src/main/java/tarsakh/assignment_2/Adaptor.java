package tarsakh.assignment_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tommy on 2015-09-09.
 */
public class Adaptor extends BaseAdapter {

    List<Movie> mMovieList;
    LayoutInflater mLayoutInflater;

    public Adaptor(List<Movie> mMovieList, LayoutInflater mLayoutInflater) {
        this.mMovieList = mMovieList;
        this.mLayoutInflater = mLayoutInflater;
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.fragment_frag__movie__list, parent, false);
        }

        Movie movie = (Movie) getItem(position);

        TextView titleTextView = (TextView) convertView.findViewById(R.id.frag_List_TextView_Movie_Title);
        titleTextView.setText(movie.titel);
        TextView yearTextView = (TextView) convertView.findViewById(R.id.frag_List_TextView_Movie_Year);
        yearTextView.setText(movie.year);
        ImageView posterImageView = (ImageView) convertView.findViewById(R.id.frag_List_ImageView_Movie_Poster);
        posterImageView.setImageResource(movie.poster);

        return convertView;
    }
}


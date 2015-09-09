package tarsakh.assignment_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return null;
    }
}

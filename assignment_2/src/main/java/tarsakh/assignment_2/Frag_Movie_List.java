package tarsakh.assignment_2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class Frag_Movie_List extends Fragment implements AdapterView.OnItemClickListener{

    List<Movie> mMovieList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypedArray movies = getResources().obtainTypedArray(R.array.movies);

        for (int i = 0 ; i < movies.length() ; i++) {
            TypedArray movieArray = getResources().obtainTypedArray(movies.getResourceId(i, 0));

            Movie movie = new Movie(
                    movieArray.getString(0),
                    movieArray.getString(1),
                    movieArray.getString(2),
                    movieArray.getResourceId(3,0),
                    movieArray.getResourceId(4,0));

            mMovieList.add(movie);
            movieArray.recycle();
        }
        movies.recycle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Frag_Start_Page", "In onCreateView");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.movie_gridview, container, false);

        GridView gridView = (GridView) v.findViewById(R.id.Frag_GridView_Movie_List);

        Adaptor adapter = new Adaptor(mMovieList, getActivity().getLayoutInflater());

        gridView.setOnItemClickListener(this);
        gridView.setAdapter(adapter);
        return v;

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentManager fm = getActivity().getSupportFragmentManager();

        Frag_Detail_Movie movieItemFragment = new Frag_Detail_Movie();

        Movie movieClick = mMovieList.get(position);

        Bundle b = new Bundle();

        b.putInt("Fanart", movieClick.fan_Art);
        b.putString("Title", movieClick.titel);
        b.putString("Year", movieClick.year);
        b.putString("Resume", movieClick.beskrivning);
        movieItemFragment.setArguments(b);


        FragmentTransaction ft = fm.beginTransaction();

        //movieItemFragment = movieItemFragment.newInstance(position);

        ft.replace(R.id.main_Activity_Id, movieItemFragment);
        ft.addToBackStack(null);
        ft.commit();

    }
}

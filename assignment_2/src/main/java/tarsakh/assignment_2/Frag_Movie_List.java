package tarsakh.assignment_2;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Frag_Movie_List extends Fragment {

    List<Movie> mMovieList = new ArrayList<>();

    public Frag_Movie_List() {
        for (int i = 0 ; i != mMovieList.size() ; ++i) {
            TypedArray movieArray = getResources().obtainTypedArray(mMovieList.(i, 0));
            Movie movie = new Movie(mMovieList.get(0).titel, mMovieList.get(1).year, mMovieList.get(2).beskrivning, mMovieList.get(3).fan_Art, mMovieList.get(4).poster);
            mMovieList.add(movie);
            movieArray.recycle();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Frag_Start_Page", "In onCreateView");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag__movie__list, container, false);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

package tarsakh.assignment_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Frag_Quote_Page.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag_Quote_Page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_Quote_Page extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

  //  private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_Quote_Page.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_Quote_Page newInstance(String param1, String param2) {
        Frag_Quote_Page fragment = new Frag_Quote_Page();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Frag_Quote_Page() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("ShowQuoteFragment", "In onCreateView");

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag__quote__page, container, false);

        String currentDate = getDate();
        TextView date = (TextView) v.findViewById(R.id.quote_Page_Time_Text);
        date.setText(currentDate);

        String [] quoteArray_list = getResources().getStringArray(R.array.array_Quotes);
        String randomQuote = getQuote(quoteArray_list);
        TextView t = (TextView) v.findViewById(R.id.quote_textview_frag_Quote_Page);
        t.setText(randomQuote);

        return v;
    }

    public static String getDate(){
        String currentDate = DateFormat.getDateInstance().format(new Date());
        return currentDate;
    }

    public static String getQuote(String[] quoteArray_list){
     //   String randomStr = quoteArray_list[new Random().nextInt(quoteArray_list.length)];
        Random rand = new Random();
        int n = rand.nextInt(5);
        return quoteArray_list[n];
    }



//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

}
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


public class Frag_Quote_Page extends Fragment {

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
        Random rand = new Random();
        int n = rand.nextInt(5);
        return quoteArray_list[n];
    }
}

package tarsakh.assignment_3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuoteFragment extends Fragment {

    List<String> mQuoteList = new ArrayList<>();
    QuoteAdapter mQuoteAdapter;
    ProgressBar mProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("QuoteFragment", "in onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("QuoteFragment", "in onCreateView");
        View v = inflater.inflate(R.layout.frag_Quote_ListShower, container, false);

        mProgressBar = (ProgressBar) v.findViewById(R.id.Frag_Quote_List_ProgressBar);
        mProgressBar.setVisibility(View.GONE);

        ListView listView = (ListView) v.findViewById(R.id.frag_Quote_List_ListView);

        mQuoteAdapter = new QuoteAdapter(mQuoteList, getActivity().getLayoutInflater());
        listView.setAdapter(mQuoteAdapter);

        FloatingActionButton fAButt = (FloatingActionButton) v.findViewById(R.id.frag_Quote_List_Button);

        fAButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("QuoteFragment", "in onItemClick");
                mProgressBar.setVisibility(View.VISIBLE);
                try {
                    URL url = new URL("https://api.github.com/zen?access_token=0f892e365071c7e778a020e463d715b8ccb816f5");
                    new ASyncTask_Download_Quotes().execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }

    private class ASyncTask_Download_Quotes extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... params) {
            Log.i("QuoteFragment", "in doInBackground");
            URL url = params[0];
            try {
                HttpURLConnection Conn = (HttpURLConnection) url.openConnection();
                try{
                    InputStream IS = new BufferedInputStream(Conn.getInputStream());
                    if (IS == null){
                        Log.i("QuoteFragment","InputStream = Null");
                    }else{
                        BufferedReader reader = new BufferedReader(new InputStreamReader(IS));
//                        StringBuilder makt = new StringBuilder();
                        String quote;
                        while((quote = reader.readLine())!= null){

                            return quote;
                        }
                    }
                }finally {
                    Conn.disconnect();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String quote) {
            Log.i("QuoteFragment", "in onPostExecute");
            mProgressBar.setVisibility(View.GONE);
            mQuoteList.add(quote);
            mQuoteAdapter.notifyDataSetChanged();
        }
    }
}
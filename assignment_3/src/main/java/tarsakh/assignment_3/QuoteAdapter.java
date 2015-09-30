package tarsakh.assignment_3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class QuoteAdapter extends BaseAdapter{

    List<String> mQuoteList;
    LayoutInflater mLayoutInflater;

    public QuoteAdapter(List<String> mQuoteList, LayoutInflater mLayoutInflater){

        this.mQuoteList = mQuoteList;
        this.mLayoutInflater = mLayoutInflater;
    }

    @Override
    public int getCount() {
        return mQuoteList.size();
    }

    @Override
    public Object getItem(int position) {
        return mQuoteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i("QuoteAdapter", "in getView");
        convertView = mLayoutInflater.inflate(R.layout.frag_Quotes, parent, false);

        String quote = mQuoteList.get(position);

        TextView quoteLine = (TextView) convertView.findViewById(R.id.frag_Quotes_TextView_Quotes);
        quoteLine.setText(quote);

        return convertView;
    }
}
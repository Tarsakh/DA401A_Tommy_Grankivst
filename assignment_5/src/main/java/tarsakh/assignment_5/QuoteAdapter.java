package tarsakh.assignment_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tommy on 2015-11-16.
 */

public class QuoteAdapter extends BaseAdapter {
    private Context mContext;
    public ArrayList<Quote> mQuote;
    private static LayoutInflater inflater = null;


    public QuoteAdapter(Context context,ArrayList<Quote> quotes)
    {
        mContext = context;
        mQuote = quotes;
    }


    @Override
    public int getCount() {
        return mQuote.size();
    }


    @Override
    public Object getItem(int position) {
        return mQuote.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView;
        inflater = ( LayoutInflater )mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.image_icon_string, null);

        Quote quote = mQuote.get(position);
        if (convertView == null)
        {

        }
        else
        {
            rowView = convertView;
        }
        TextView tw1 = (TextView) rowView.findViewById(R.id.textview_quote);
        tw1.setText(quote.quote);
        return rowView;
    }
}
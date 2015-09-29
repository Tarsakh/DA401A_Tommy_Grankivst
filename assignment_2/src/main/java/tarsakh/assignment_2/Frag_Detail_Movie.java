package tarsakh.assignment_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

public class Frag_Detail_Movie extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_frag__detail__movie, container, false);
        Bundle b = getArguments();

        ImageView imageView = (ImageView) v.findViewById(R.id.frag_Detail_imageView_Movie_Cover);
        TextView textView1 = (TextView) v.findViewById(R.id.frag_Detail_TextView_Movie_Title);
        TextView textView2 = (TextView) v.findViewById(R.id.frag_Detail_TextView_Movie_Year);
        TextView textView3 = (TextView) v.findViewById(R.id.frag_Detail_TextView_Movie_Resume);

        imageView.setImageResource(b.getInt("Fanart"));
        textView1.setText(b.getString("Title"));
        textView2.setText(b.getString("Year"));
        textView3.setText(b.getString("Resume"));

        return v;
    }
}

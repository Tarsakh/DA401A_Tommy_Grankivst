package tarsakh.assignment_5;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Tommy on 2015-11-16.
 */

public class FragmentAdapter extends FragmentPagerAdapter
{
    final int tab_Count = 1;
    private String tabTitles[] = new String[] { "Quotes"};
    private Context context;


    public FragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ZenFragment();
                break;
            }
        return fragment;
    }


    @Override
    public int getCount() {
        return tab_Count;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabTitles[position];
    }
}
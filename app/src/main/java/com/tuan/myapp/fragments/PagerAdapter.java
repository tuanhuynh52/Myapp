package com.tuan.myapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.astuetz.PagerSlidingTabStrip;
import com.tuan.myapp.MyMapFragment;
import com.tuan.myapp.R;

/**
 * Created by Tuan on 9/20/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter
        implements PagerSlidingTabStrip.IconTabProvider{

    final int PAGE_COUNT = 2;
    private int tabIcons[] = {R.drawable.ic_map, R.drawable.ic_list};

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new MyMapFragment();
        } else {
            return new MyListFragment();
        }


    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}

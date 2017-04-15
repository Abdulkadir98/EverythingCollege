package com.example.hp.main.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp.main.fragments.eligibilityFragment;
import com.example.hp.main.fragments.scholarshipsFragment;
import com.example.hp.main.fragments.searchFragment;
import com.example.hp.main.fragments.topHundredFragment;

/**
 * Created by admin on 2/12/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Top25", "Search", "Eligibility", "Scholarships"};
    public SimpleFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new topHundredFragment();
            case 1: return new searchFragment();
            case 2: return new eligibilityFragment();
            case 3: return new scholarshipsFragment();
            default: throw new IllegalArgumentException("Cannot find Fragment");
        //
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return tabTitles[position];
//    }
}

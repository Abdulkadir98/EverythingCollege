package com.example.hp.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by admin on 2/12/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Top25", "Search", "Eligibility", "EntranceTests", "Scholarships"};
    public SimpleFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new topHundredFragment();
            case 1: return new searchFragment();
            case 2: return new eligibilityFragment();
            case 3: return new examsFragment();
            case 4: return new scholarshipsFragment();
            default: throw new IllegalArgumentException("Cannot find Fragment");
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

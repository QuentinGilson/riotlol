package com.gilson.quentin.riotlol.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gilson.quentin.riotlol.fragment.LiveGameFragment;
import com.gilson.quentin.riotlol.fragment.PlayerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 10-10-17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> allFragment;
    private String[] allTitles;

    public PagerAdapter(FragmentManager fm) {
        super(fm);

        allFragment = new ArrayList<>();
        allFragment.add(PlayerFragment.newInstance());
        allFragment.add(LiveGameFragment.newInstance());

        allTitles = new String[]{"info","live"};
    }

    @Override
    public Fragment getItem(int position) {
        return allFragment.get(position);
    }

    @Override
    public int getCount() {
        return allFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return allTitles[position];
    }
}

package com.gilson.quentin.riotlol.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilson.quentin.riotlol.R;
import com.gilson.quentin.riotlol.adapter.PagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    public PagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        unbinder = ButterKnife.bind(this, view);

        PagerAdapter pagerAdapter = new PagerAdapter(this.getFragmentManager());
        viewpager.setAdapter(pagerAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setBackgroundColor(getResources().getColor(R.color.myBlue));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

package com.gilson.quentin.riotlol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilson.quentin.riotlol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveGameFragment extends Fragment {


    public LiveGameFragment() {
        // Required empty public constructor
    }

    public static LiveGameFragment newInstance() {
        Bundle args = new Bundle();

        LiveGameFragment fragment = new LiveGameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_game, container, false);
    }

}

package com.gilson.quentin.riotlol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gilson.quentin.riotlol.R;
import com.gilson.quentin.riotlol.request.RiotRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment implements RiotRequest.PlayerInfoListener {


    @BindView(R.id.textviewtest)
    TextView textviewtest;
    Unbinder unbinder;

    public PlayerFragment() {
        // Required empty public constructor
    }

    public static PlayerFragment newInstance() {
        Bundle args = new Bundle();
        PlayerFragment fragment = new PlayerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        unbinder = ButterKnife.bind(this, view);

        RiotRequest.getPlayerInfo(this,"5skunk");

        return view;
    }

    @Override
    public void didReceivePlayerInfo(String name) {
        textviewtest.setText(name);
    }

    @Override
    public void didFail() {
        textviewtest.setText("fail");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

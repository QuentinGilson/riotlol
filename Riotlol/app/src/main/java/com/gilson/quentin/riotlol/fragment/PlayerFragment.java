package com.gilson.quentin.riotlol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilson.quentin.riotlol.R;
import com.gilson.quentin.riotlol.adapter.RecentMatchItem;
import com.gilson.quentin.riotlol.model.Champion;
import com.gilson.quentin.riotlol.model.ChampionList;
import com.gilson.quentin.riotlol.model.Item;
import com.gilson.quentin.riotlol.model.ItemList;
import com.gilson.quentin.riotlol.model.Match;
import com.gilson.quentin.riotlol.model.MatchStats;
import com.gilson.quentin.riotlol.model.ParticipantIdentity;
import com.gilson.quentin.riotlol.model.PlayerResult;
import com.gilson.quentin.riotlol.model.RecentMatchResult;
import com.gilson.quentin.riotlol.model.SummonerSpell;
import com.gilson.quentin.riotlol.model.SummonerSpellList;
import com.gilson.quentin.riotlol.realm.ChampionRealmObject;
import com.gilson.quentin.riotlol.realm.ItemRealmObject;
import com.gilson.quentin.riotlol.realm.RealmManager;
import com.gilson.quentin.riotlol.realm.SavedUser;
import com.gilson.quentin.riotlol.realm.SummonerSpellRealmObject;
import com.gilson.quentin.riotlol.request.RiotRequest;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment implements RiotRequest.PlayerInfoListener, RiotRequest.RecentMatchListener, RiotRequest.MatchStatsListener {

    Unbinder unbinder;
    @BindView(R.id.recent_match_recycleview)
    RecyclerView recentMatchRecycleview;

    private FastItemAdapter<AbstractItem> recentMatchAdapter;
    private String accountId;

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

        initRecyclerView();

        return view;
    }

    public void refresh() {
        SavedUser user = RealmManager.getRealmManager().getSavedUser();
        if(!user.getName().equals(user.getNewName())){
            RealmManager.getRealmManager().updateSavedUserName(user.getNewName());

            if(recentMatchAdapter!=null){
                recentMatchAdapter.clear();
            }

            RiotRequest.getPlayerInfo(this, RealmManager.getRealmManager().getSavedUser().getName());
        }
    }

    public void initRecyclerView() {
        recentMatchAdapter = new FastItemAdapter<>();
        recentMatchRecycleview.setAdapter(recentMatchAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recentMatchRecycleview.setLayoutManager(linearLayoutManager);

        RealmManager.getRealmManager().updateSavedUserName("");
        refresh();
    }

    @Override
    public void didReceivePlayerInfo(PlayerResult result) {
        accountId = String.valueOf(result.getAccountId());
        RiotRequest.getRecentMatch(this, accountId);
    }

    @Override
    public void didReceiveRecentMatch(RecentMatchResult result) {
        List<Match> allMatch = result.getMatches();
        for (Match match : allMatch) {
            RiotRequest.getMatchStats(this, String.valueOf(match.getGameId()));
        }
    }

    @Override
    public void didReceiveMatchStats(MatchStats matchStats) {
        RecentMatchItem item = new RecentMatchItem(matchStats,Integer.parseInt(accountId),getContext());
        recentMatchAdapter.add(item);
    }

    @Override
    public void didFail() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

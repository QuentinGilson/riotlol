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
import com.gilson.quentin.riotlol.model.Champion;
import com.gilson.quentin.riotlol.model.ChampionList;
import com.gilson.quentin.riotlol.model.Item;
import com.gilson.quentin.riotlol.model.ItemList;
import com.gilson.quentin.riotlol.model.SummonerSpell;
import com.gilson.quentin.riotlol.model.SummonerSpellList;
import com.gilson.quentin.riotlol.realm.ChampionRealmObject;
import com.gilson.quentin.riotlol.realm.ItemRealmObject;
import com.gilson.quentin.riotlol.realm.RealmManager;
import com.gilson.quentin.riotlol.realm.SavedUser;
import com.gilson.quentin.riotlol.realm.SummonerSpellRealmObject;
import com.gilson.quentin.riotlol.request.RiotRequest;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment implements TabLayout.OnTabSelectedListener, RiotRequest.ChampionListener, RiotRequest.SummonerSpellListener, RiotRequest.ItemListener {


    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;
    private PagerAdapter pagerAdapter;

    public PagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        unbinder = ButterKnife.bind(this, view);

        pagerAdapter = new PagerAdapter(this.getFragmentManager(),tablayout);
        viewpager.setAdapter(pagerAdapter);
        tablayout.addOnTabSelectedListener(this);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setBackgroundColor(getResources().getColor(R.color.myBlue));
        if(RealmManager.getRealmManager().getSavedUser()!=null){
            tablayout.getTabAt(1).select();
        } else {
            RiotRequest.getChampion(this);
            RiotRequest.getSummonerSpell(this);
            RiotRequest.getItem(this);
            SavedUser user = new SavedUser();
            user.setNewName("");
            user.setName("");
            user.setId(0);
            RealmManager.getRealmManager().createSavedUser(user);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if(tab.getPosition()==1){
            PlayerFragment fragment = (PlayerFragment) pagerAdapter.getItem(1);
            fragment.refresh();
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void didReceiveChampion(ChampionList championList) {

        for(Champion champion : championList.getData().values()){
            RealmManager.getRealmManager().addChampion(new ChampionRealmObject(champion));
        }
    }

    @Override
    public void didFail() {

    }

    @Override
    public void didReceiveSummonerSpell(SummonerSpellList summonerSpellList) {
        for(SummonerSpell summonerSpell : summonerSpellList.getData().values()){
            RealmManager.getRealmManager().addSummonerSpell(new SummonerSpellRealmObject(summonerSpell));
        }
    }

    @Override
    public void didReceiveItem(ItemList itemList) {
        for(Item item : itemList.getData().values()) {
            RealmManager.getRealmManager().addItem(new ItemRealmObject((item)));
        }
    }
}

package com.gilson.quentin.riotlol.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.gilson.quentin.riotlol.R;
import com.gilson.quentin.riotlol.activity.PagerActivity;
import com.gilson.quentin.riotlol.realm.RealmManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private TabLayout tabLayout;

    @BindView(R.id.edittext_search)
    EditText edittextSearch;
    @BindView(R.id.button_search)
    Button buttonSearch;
    Unbinder unbinder;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(TabLayout tabLayout) {
        SearchFragment fragment = new SearchFragment();
        fragment.tabLayout = tabLayout;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.button_search)
    public void onViewClicked() {
        RealmManager.getRealmManager().updateSavedUserNewName(edittextSearch.getText().toString().replace(" ",""));
        edittextSearch.setText("");

        InputMethodManager imm = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edittextSearch.getRootView().getWindowToken(), 0);

        tabLayout.getTabAt(1).select();
    }
}

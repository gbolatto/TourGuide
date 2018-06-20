package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopsFragment extends Fragment {

    private static final String TAG = "ShopsFragment";
    protected RecyclerView mRecyclerView;

    public ShopsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);
        rootView.setTag(TAG);

        // This information would normally be pulled in from a local db or remote API in a
        // future version of the app, so no need to string reference the data here in the app
        // but did it anyway. Also string referenced the links to keep things uniform.
        ArrayList<Attraction> mShops = new ArrayList<>();
        mShops.add(new Attraction(
                getString(R.string.atomic_empire),
                getString(R.string.atomic_empire_location),
                getString(R.string.atomic_empire_map_link),
                getString(R.string.atomic_empire_details),
                getString(R.string.atomic_empire_website),
                R.drawable.atomic_empire));
        mShops.add(new Attraction(
                getString(R.string.game_theory),
                getString(R.string.game_theory_location),
                getString(R.string.game_theory_map_link),
                getString(R.string.game_theory_details),
                getString(R.string.game_theory_website),
                R.drawable.gametheory));
        mShops.add(new Attraction(
                getString(R.string.gamers_armory),
                getString(R.string.gamers_armory_location),
                getString(R.string.gamers_armory_map_link),
                getString(R.string.gamers_armory_details),
                getString(R.string.gamers_armory_website),
                R.drawable.gamers_armory));

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AttractionAdapter mAdapter = new AttractionAdapter(getContext(), mShops);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}

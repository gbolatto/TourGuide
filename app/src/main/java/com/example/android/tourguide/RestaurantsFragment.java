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
public class RestaurantsFragment extends Fragment {

    private static final String TAG = "RestaurantsFragment";
    protected RecyclerView mRecyclerView;

    public RestaurantsFragment() {
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
        ArrayList<Attraction> mRestaurants = new ArrayList<>();
        mRestaurants.add(new Attraction(
                getString(R.string.angus_barn),
                getString(R.string.angus_barn_location),
                getString(R.string.angus_barn_map_link),
                getString(R.string.angus_barn_details),
                getString(R.string.angus_barn_website),
                R.drawable.angus));
        mRestaurants.add(new Attraction(
                getString(R.string.pizzeria_toro),
                getString(R.string.pizzeria_toro_location),
                getString(R.string.pizzeria_toro_map_link),
                getString(R.string.pizzeria_toro_details),
                getString(R.string.pizzeria_toro_website),
                R.drawable.pizza));
        mRestaurants.add(new Attraction(
                getString(R.string.rue_cler),
                getString(R.string.rue_cler_location),
                getString(R.string.rue_cler_map_link),
                getString(R.string.rue_cler_details),
                getString(R.string.rue_cler_website),
                R.drawable.ruecler));


        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AttractionAdapter mAdapter = new AttractionAdapter(getContext(), mRestaurants);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}

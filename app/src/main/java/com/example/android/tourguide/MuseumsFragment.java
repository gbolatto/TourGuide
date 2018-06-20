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
public class MuseumsFragment extends Fragment {

    private static final String TAG = "MuseumsFragment";
    protected RecyclerView mRecyclerView;

    public MuseumsFragment() {
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
        ArrayList<Attraction> mMuseums = new ArrayList<>();
        mMuseums.add(new Attraction(
                getString(R.string.natural_sciences),
                getString(R.string.natural_sciences_location),
                getString(R.string.natural_sciences_map_link),
                getString(R.string.natural_sciences_details),
                getString(R.string.natural_sciences_website),
                R.drawable.natural_sciences));
        mMuseums.add(new Attraction(
                getString(R.string.museum_of_art),
                getString(R.string.museum_of_art_location),
                getString(R.string.museum_of_art_map_link),
                getString(R.string.museum_of_art_details),
                getString(R.string.museum_of_art_website),
                R.drawable.art));
        mMuseums.add(new Attraction(
                getString(R.string.life_and_science),
                getString(R.string.life_and_science_location),
                getString(R.string.life_and_science_map_link),
                getString(R.string.life_and_science_details),
                getString(R.string.life_and_science_website),
                R.drawable.life));

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AttractionAdapter mAdapter = new AttractionAdapter(getContext(), mMuseums);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}

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
public class LakesFragment extends Fragment {

    private static final String TAG = "LakesFragment";
    protected RecyclerView mRecyclerView;

    public LakesFragment() {
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
        ArrayList<Attraction> mLakes = new ArrayList<>();
        mLakes.add(new Attraction(
                getString(R.string.falls_lake),
                getString(R.string.falls_lake_location),
                getString(R.string.falls_lake_map_link),
                getString(R.string.falls_lake_details),
                getString(R.string.falls_lake_website),
                R.drawable.falls));
        mLakes.add(new Attraction(
                getString(R.string.jordan_lake),
                getString(R.string.jordan_lake_location),
                getString(R.string.jordan_lake_map_link),
                getString(R.string.jordan_lake_details),
                getString(R.string.jordan_lake_website),
                R.drawable.jordan));
        mLakes.add(new Attraction(
                getString(R.string.shearon_harris),
                getString(R.string.shearon_harris_location),
                getString(R.string.shearon_harris_map_link),
                getString(R.string.shearon_harris_details),
                getString(R.string.shearon_harris_website),
                R.drawable.harris));
        mLakes.add(new Attraction(
                getString(R.string.lake_johnson),
                getString(R.string.lake_johnson_location),
                getString(R.string.lake_johnson_map_link),
                getString(R.string.lake_johnson_details),
                getString(R.string.lake_johnson_website),
                R.drawable.johnson));

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AttractionAdapter mAdapter = new AttractionAdapter(getContext(), mLakes);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}

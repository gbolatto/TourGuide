package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by gbolatto on 6/19/2018.
 */
public class CategoryAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LakesFragment();
        } if (position == 1) {
            return new MuseumsFragment();
        } if (position == 2) {
            return new ShopsFragment();
        } else {
            return new RestaurantsFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.lakes);
        } if (position == 1) {
            return mContext.getString(R.string.museums);
        } if (position == 2) {
            return mContext.getString(R.string.shops);
        } else {
            return mContext.getString(R.string.restaurants);
        }
    }
}

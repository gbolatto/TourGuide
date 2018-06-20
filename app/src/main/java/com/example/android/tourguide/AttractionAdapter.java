package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gbolatto on 6/19/2018.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.ViewHolder>{

    private static final String TAG = "AttractionAdapter";

    private Context mContext;
    private ArrayList<Attraction> mAttractions;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView attractionNameTextView;
        private final ImageView attractionImageView;
        private final TextView attractionLocationTextView;
        private final ImageView gPinImageView;
        private final TextView attractionDetailedInfoTextView;
        private final TextView attractionWebsiteTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            attractionNameTextView = itemView.findViewById(R.id.attraction_name);
            attractionImageView = itemView.findViewById(R.id.attraction_image);
            attractionLocationTextView = itemView.findViewById(R.id.attraction_location);
            gPinImageView = itemView.findViewById(R.id.g_map_pin);
            attractionDetailedInfoTextView = itemView.findViewById(R.id.attraction_detailed_info);
            attractionWebsiteTextView = itemView.findViewById(R.id.attraction_website);
        }

        public TextView getAttractionNameTextView() {
            return attractionNameTextView;
        }

        public ImageView getAttractionImageView() {
            return attractionImageView;
        }

        public TextView getAttractionLocationTextView(){
            return attractionLocationTextView;
        }

        public ImageView getGPinImageView(){
            return gPinImageView;
        }

        public TextView getAttractionDetailedInfoTextView() {
            return attractionDetailedInfoTextView;
        }

        public TextView getAttractionWebsiteTextView() {
            return attractionWebsiteTextView;
        }
    }

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions) {
        mContext = context;
        mAttractions = attractions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Attraction current = mAttractions.get(position);

        holder.getAttractionNameTextView().setText(current.getName());

        if (current.getImageResourceId() != -1) {
            holder.getAttractionImageView().setImageResource(current.getImageResourceId());
        }

        holder.getAttractionLocationTextView().setText(current.getLocation());
        holder.getAttractionDetailedInfoTextView().setText(current.getDetailedInfo());
        holder.getAttractionWebsiteTextView().setText(current.getWebsite());

        final String currentLocationLink = current.getLocationLink();

        holder.getGPinImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentLocationLink));
                mContext.startActivity(mapIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAttractions.size();
    }
}

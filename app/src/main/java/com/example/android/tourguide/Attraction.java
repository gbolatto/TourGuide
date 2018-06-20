package com.example.android.tourguide;

/**
 * Created by gbolatto on 6/19/2018.
 */
public class Attraction {

    private String mName;
    private String mLocation;
    private String mLocationLink;
    private String mDetailedInfo;
    private String mWebsite;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Attraction object
     * @param name is the name of the attraction
     * @param location is the address or general area
     * @param locationLink is a link for google maps
     * @param detailedInfo is a description of the attraction
     * @param website is a website to the attraction
     */
    public Attraction(String name, String location, String locationLink, String detailedInfo, String website){
        mName = name;
        mLocation = location;
        mLocationLink = locationLink;
        mDetailedInfo = detailedInfo;
        mWebsite = website;
    }

    /**
     * Create a new Attraction object
     * @param name is the name of the attraction
     * @param location is the address or general area
     * @param locationLink is the address or general ar
     * @param detailedInfo is a description of the attraction
     * @param website is a website to the attraction
     * @param imageResourceId is the resource id of the image file
     */
    public Attraction(String name, String location, String locationLink, String detailedInfo, String website, int imageResourceId){
        mName = name;
        mLocation = location;
        mLocationLink = locationLink;
        mDetailedInfo = detailedInfo;
        mWebsite = website;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getLocationLink() {
        return mLocationLink;
    }

    public String getDetailedInfo() {
        return mDetailedInfo;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}

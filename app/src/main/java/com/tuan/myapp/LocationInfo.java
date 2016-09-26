package com.tuan.myapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuan on 9/21/2016.
 */

public class LocationInfo {

    private double lat, lng;


    public LocationInfo() {

    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public static List<Parking> PARKING_DATA = new ArrayList<>();

}

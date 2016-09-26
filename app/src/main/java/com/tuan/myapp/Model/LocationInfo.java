package com.tuan.myapp.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuan on 9/25/2016.
 */

public class LocationInfo {

    private int numberOfLocations;

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public static List<Parking> PARKING_DATA = new ArrayList<>();
}

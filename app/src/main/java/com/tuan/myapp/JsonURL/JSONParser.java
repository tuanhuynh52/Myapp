package com.tuan.myapp.JsonURL;

import android.content.Context;
import android.util.Log;

import com.tuan.myapp.Model.Parking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuan on 9/23/2016.
 */

public class JSONParser {

    private static final String TAG = "JsonParser";
    private String content;
    private Context context;
    private int numberOfLocation;
    private List<Parking> PARKING_DATA;


    public JSONParser(String content){
        this.content = content;
    }

    public List<Parking> getParkingList(){

        Log.i(TAG, "getParkingList running");
        List<Parking> parkingList = new ArrayList<Parking>();

        try {
            JSONObject jsonObject = new JSONObject(content);
            numberOfLocation = jsonObject.getInt("locations");
            Log.i(TAG, numberOfLocation+"");
            JSONArray parkingArray = jsonObject.getJSONArray("parking_listings");
            Log.i(TAG, parkingArray.length()+"");
            for (int i=0; i < parkingArray.length(); i++){
                JSONObject currentParking = parkingArray.getJSONObject(i);

                String city = currentParking.getString("city");
                String name = currentParking.getString("location_name");
                String address = currentParking.getString("address");
                String state = currentParking.getString("state");
                String zip = currentParking.getString("zip");
                String formatted_price = currentParking.getString("price_formatted");

                int location_id = currentParking.getInt("location_id");
                int listing_id = currentParking.getInt("listing_id");
                int available_spots = currentParking.getInt("available_spots");

                double gotLat = currentParking.getDouble("lat");
                double gotLng = currentParking.getDouble("lng");
                double price = currentParking.getDouble("price");

                Parking myParking = new Parking(city, name, address, state, zip, formatted_price,
                        location_id, listing_id, available_spots,
                        price, gotLat, gotLng);
                Log.i(TAG, myParking.toString());
                parkingList.add(myParking);
            }

            return parkingList;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}

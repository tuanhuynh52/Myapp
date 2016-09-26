package com.tuan.myapp.Controller;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tuan.myapp.JsonURL.JSONParser;
import com.tuan.myapp.JsonURL.JsonLocationUrl;
import com.tuan.myapp.Model.LocationInfo;
import com.tuan.myapp.Model.Parking;
import com.tuan.myapp.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyMapFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "MyMapFragment";
    private MapView mapView;
    private GoogleMap map;
    private List<Marker> markerArray;
    private double lat, lng;
    private LocationInfo locationInfo;
    private List<Parking> parkingList;
    private int numberOfLocation;

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public MyMapFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_map, container, false);
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this); //this is important
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
//        Log.i("MapFragment", "my lat: "+lat + "my lng: "+ lng);
        markerArray = new ArrayList<Marker>();
//        for (int i=0; i <= parkings.size(); i++) {
//            double nearbyLat = parkings.get(i).getGotLat();
//            double nearbyLng = parkings.get(i).getGotLng();
//            double price = parkings.get(i).getPrice();
//            for (Marker marker: markerArray){
//                LatLng nearbyPosition = new LatLng(nearbyLat, nearbyLng);
//                marker = map.addMarker(new MarkerOptions().position(nearbyPosition)
//                                    .title("$"+price));
//                markerArray.add(marker);
//            }
//        }
//        Log.i(TAG, markerArray.size()+"");
        LatLng position = new LatLng(lat, lng);
        map.getUiSettings().setZoomControlsEnabled(true);
        MarkerOptions marker = new MarkerOptions();
        map.addMarker(marker.position(position));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 12));

        new SearchTask().execute();

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    private class SearchTask extends AsyncTask<String, String, List<Parking>> {

        MyMapFragment myMapFragment = new MyMapFragment();

        /**
         * Preparing to execute task.
         */
        @Override
        protected void onPreExecute() {
//            Log.i(TAG, "Starting task");
//            mProgressBar.setVisibility(View.VISIBLE);
        }

        /**
         * Use the connection to make a http request to the
         * web service.
         * @param params a String URL for making the service request.
         * @return a list of possible nearby location matching the
         * user's request inputs. Null if no matching content.
         */
        @Override
        protected List<Parking> doInBackground(String... params) {
            JsonLocationUrl myConnection = new JsonLocationUrl();
            String content;

            Log.i(TAG, "running doinBackground");
            try {
                content = myConnection.getJson(lat, lng);
                if (content != null) {
                    // Get a list of places by parsing the JSON
                    // text content.
                    Log.i(TAG, content);
                    parkingList = new JSONParser(content).getParkingList();
                    return parkingList;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Parking> parkings) {
            //            if (places != null) {
            //                sCurrentPlaces = places;
            //                displayList();
            //            } else {
            //                Log.i(TAG, "can't parse, places is null");
            //            }
            //            mProgressBar.setVisibility(View.INVISIBLE);
            Log.i(TAG, "task finished");
        }
    }

}

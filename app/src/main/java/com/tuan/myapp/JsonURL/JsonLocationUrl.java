package com.tuan.myapp.JsonURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Tuan on 9/21/2016.
 */

public class JsonLocationUrl {

    private static String myApiKey ="477e53144a5e5caa675d2db2768b7782";

    public JsonLocationUrl() {

    }

    public String getJson(double lat, double lng) throws IOException {

        URL url;
        HttpURLConnection conn = null;
        InputStream is = null;
        String myUrl = "http://api.parkwhiz.com/search/?lat="+lat+"&lng="+lng+"&key="+myApiKey;

        try {
            url = new URL(myUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            //int response = conn.getResponseCode();
            //Log.d("JSONAddressUrl", "response code: "+ response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = getStringFromInputStream(is);
            return contentAsString;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }

        return null;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}

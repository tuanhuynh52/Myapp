package com.tuan.myapp;

/**
 * Created by Tuan on 9/23/2016.
 */

public class Parking {

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String formatted_price;
    private int location_id, listing_id, availableSpot;
    private double price, gotLat, gotLng;

    public Parking(String city, String name, String address, String state, String zip, String formatted_price,
                   int location_id, int listing_id, int availableSpot,
                   double price, double gotLat, double gotLng) {
        this.city = city;
        this.name = name;
        this.address = address;
        this.state = state;
        this.zip = zip;
        this.formatted_price = formatted_price;
        this.location_id = location_id;
        this.listing_id = listing_id;
        this.availableSpot = availableSpot;
        this.price = price;
        this.gotLat = gotLat;
        this.gotLng = gotLng;
    }

    public String getFormatted_price() {
        return formatted_price;
    }

    public void setFormatted_price(String formatted_price) {
        this.formatted_price = formatted_price;
    }

    public double getGotLat() {
        return gotLat;
    }

    public void setGotLat(double gotLat) {
        this.gotLat = gotLat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }

    public int getAvailableSpot() {
        return availableSpot;
    }

    public void setAvailableSpot(int availableSpot) {
        this.availableSpot = availableSpot;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGotLng() {
        return gotLng;
    }

    public void setGotLng(double gotLng) {
        this.gotLng = gotLng;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", formatted_price='" + formatted_price + '\'' +
                ", location_id=" + location_id +
                ", listing_id=" + listing_id +
                ", availableSpot=" + availableSpot +
                ", price=" + price +
                ", gotLat=" + gotLat +
                ", gotLng=" + gotLng +
                '}';
    }



}

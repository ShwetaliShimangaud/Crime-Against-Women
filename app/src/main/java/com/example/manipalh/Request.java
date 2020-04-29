package com.example.manipalh;

import java.util.ArrayList;

public class Request {
    double latitude;
    double longitude;
    ArrayList<String> arr;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<String> getArr() {
        return arr;
    }

    public void setArr(ArrayList<String> arr) {
        this.arr = arr;
    }

    public Request(double latitude, double longitude, ArrayList<String> arr) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.arr = arr;
    }
}

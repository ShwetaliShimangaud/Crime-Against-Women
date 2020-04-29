package com.example.manipalh;

public class User {
    String name, phno, emailid, phno1, phno2;
    double lat, lon;


    public User(String name, String phno, String emailid, String phno1) {
        this.name = name;
        this.phno = phno;
        this.emailid = emailid;
        this.phno1 = phno1;
        this.lon = lon;
        this.lat = lat;
        this.phno2 = phno2;

    }

    public String getName() {
        return name;
    }

    public String getPhno() {
        return phno;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPhno1() {
        return phno1;
    }

    public String getPhno2() {
        return phno2;
    }

    public double getLat(){
        return lat;

    }
    public  double getLon()
    {
        return lon;
    }

}

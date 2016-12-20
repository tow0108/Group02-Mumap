package com.egco428.a13283_a13265.mumap.Tram;

public class TramPath {
    private long id;
    private String number;
    private String name;
    private String type;
    private String latitude;
    private String longtitude;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setNumber(String number) {this.number = number;}
    public String getNumber() {return number;}

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }


    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLatitude() {
        return latitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
    public String getLongtitude() {
        return longtitude;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return name;
    }
}
package com.example.ga.airwayplan;

public class Routing {

    private String place;
    private String time;

    public Routing(){ }

    public Routing(String place , String time){
        this.place = place;
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {

        return time;
    }

}

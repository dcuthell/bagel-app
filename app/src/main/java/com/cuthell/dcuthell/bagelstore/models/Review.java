package com.cuthell.dcuthell.bagelstore.models;

import java.util.ArrayList;

/**
 * Created by dcuthell on 10/22/2017.
 */

public class Review {
    private String url;
    private String text;
    private double rating;
    private ArrayList<String> user = new ArrayList<>();
    private String timeCreated;

    public Review(String url, String text, double rating, ArrayList<String> user, String timeCreated) {
        this.url = url;
        this.text = text;
        this.rating = rating;
        this.user = user;
        this.timeCreated = timeCreated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getUser() {
        return user;
    }

    public void setUser(ArrayList<String> user) {
        this.user = user;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}

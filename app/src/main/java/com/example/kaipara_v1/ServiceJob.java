package com.example.kaipara_v1;

import java.sql.Date;
import java.sql.Time;

public class ServiceJob {

    private String title;
    private String imagePath;
    private String description;
    private String price;
    private String date;
    private String starttime;
    private String finishtime;
    private String street;
    private String suburb;
    private String postcode;

    public ServiceJob(){}

    public ServiceJob(String title, String imagePath, String description, String price, String date ,String starttime, String finishtime, String street,String suburb, String postcode){
        this.title = title;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
        this.date = date;
        this.starttime = starttime;
        this.finishtime = finishtime;
        this.street = street;
        this.suburb = suburb;
        this.postcode = postcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}

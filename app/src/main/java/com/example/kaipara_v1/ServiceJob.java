package com.example.kaipara_v1;

import java.sql.Date;
import java.sql.Time;

public class ServiceJob {

    private String title;
    private String imagePath;
    private String description;
    private String status;
    private String price;
    private String date;
    private String end_date;
    private String street;
    private String suburb;
    private String city;
    private String postcode;

    public ServiceJob(){}

    public ServiceJob(String title, String imagePath, String description, String status, String price, String date , String end_date, String street, String suburb, String city, String postcode){
        this.title = title;
        this.status = status;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
        this.date = date;
        this.end_date = end_date;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        if(end_date == "null"){
            this.end_date = " ";
        }else{
            this.end_date = end_date;
        }

    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String st;
        switch (status){
            case "1":
                st = "Unaccepted";
                break;
            case "2":
                st = "Accepted";
                break;
            case "3":
                st = "started";
                break;
            case "4":
                st = "Complete";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        this.status = st;
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
        if(price == "null"){
            this.price = "Quotable";
        }else{
            this.price = price;
        }

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

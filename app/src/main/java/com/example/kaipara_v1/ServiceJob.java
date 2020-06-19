package com.example.kaipara_v1;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    private String month;

    public ServiceJob(){}

    public ServiceJob(String title, String imagePath, String description, String status, String price,
                      String date , String end_date, String street, String suburb,
                      String city, String month){
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
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) throws ParseException {
        String finalMonth = null;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String check= new SimpleDateFormat("MMMM").format(calendar.get(Calendar.MONTH));

        switch(check){
            case "January":
                finalMonth = "Jan";
                break;
            case "February":
                finalMonth = "Feb";
                break;
            case "March":
                finalMonth = "Mar";
                break;
            case "April":
                finalMonth = "Apr";
                break;
            case "May":
                finalMonth = "May";
                break;
            case "June":
                finalMonth = "Jun";
                break;
            case "July":
                finalMonth = "Jul";
                break;
            case "August":
                finalMonth = "Aug";
                break;
            case "September":
                finalMonth = "Sep";
                break;
            case "October":
                finalMonth = "Oct";
                break;
            case "November":
                finalMonth = "Nov";
                break;
            case "December":
                finalMonth = "Dec";
                break;
        }
        this.month = finalMonth;
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
                st = "Started";
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
            this.price = "QUOTABLE";
        }else{
            this.price ="$"+price;
        }
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        String finalDay = null;
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        finalDay = (String) android.text.format.DateFormat.format("dd",d);
        this.date = finalDay;
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

}

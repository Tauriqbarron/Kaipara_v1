package com.example.kaipara_v1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class SecurityBookings {

    private String description;
    private String price;
    private String status;
    private String street;
    private String suburb;
    private String city;
    private String start_date;
    private String day_num;
    private String month;
    private String end_date;
    private String start_time;
    private String end_time;
    private boolean expanded;

    public SecurityBookings(){}

    public SecurityBookings(String description, String price, String status, String street,
                            String suburb, String city, String start_date, String end_date,
                            String start_time, String end_time,String day_num,String month){
        this.description = description;
        this.price = price;
        this.status = status;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.day_num = day_num;
        this.month = month;
        this.expanded = false;
    }

    public String getDay_num() {
        return day_num;
    }

    public void setDay_num(String day_num) throws ParseException {
       String finalDay = null;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(day_num);
        finalDay = (String) android.text.format.DateFormat.format("dd",date);
        this.day_num = finalDay;
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

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
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
        this.price = "$"+ price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String stat;
        stat = status.toUpperCase();
        this.status = stat;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) throws ParseException {
        String day;
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(start_date);
        DateFormat format1 = new SimpleDateFormat("EEEE");
        day = format1.format(date);
        switch (day){
            case "Sunday":
                day = "Sun";
                break;
            case "Monday":
                day = "Mon";
                break;
            case "Tuesday":
                day = "Tues";
                break;
            case "Wednesday":
                day = "Wed";
                break;
            case "Thursday":
                day = "Thurs";
                break;
            case "Friday":
                day = "Fri";
                break;
            case "Saturday":
                day = "Sat";
                break;
        }
        this.start_date = day;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {

        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        String time = null;
        this.end_time = end_time;
    }


}

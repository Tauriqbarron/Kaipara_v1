package com.example.kaipara_v1;

public class Application {
    private String type;
    private String price;
    private String title;
    private String name;
    private String number;
    private String description;
    private String street;
    private String suburb;
    private String city;
    private String address;
    private String imgPath;

    public Application(){}

    public Application(String type, String price, String title, String name, String number,
                       String description, String street, String suburb, String city,String imgPath){
        this.type = type;
        this.price = price;
        this.title = title;
        this.name = name;
        this.number = number;
        this.description = description;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
        this.imgPath = imgPath;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstname, String lastname) {
        this.name = firstname+" "+lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String street,String suburb,String city) {

        this.address = street +", "+ suburb+", "+ city;
    }
}

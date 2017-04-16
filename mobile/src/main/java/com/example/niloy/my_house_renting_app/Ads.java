package com.example.niloy.my_house_renting_app;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by niloy on 3/23/2017.
 */

public class Ads {

    public String Name;
    public String URL;

    public String Owner;
    public String Division;
    public String Address;
    public String Description;
    public int Price;
    public int Contact;

    public Ads() {
        this.setURL(URL);
        this.setName(Name);
        this.setOwner(Owner);
        this.setDivision(Division);
        this.setAddress(Address);
        this.setDescription(Description);
        this.setPrice(Price);
        this.setContact(Contact);
    }

    public Ads(String name, String url, String owner, String division, String address, String description, int price, int contact) {

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

}

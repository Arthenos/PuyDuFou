package com.exia.puydufou.BusinessObject;

import android.graphics.Region;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by maxim_000 on 16/06/2015.
 */
public class ShopBU implements Serializable {


    //region Attributes
    private int id;
    private String name;
    private String description;
    private String location;
    private ArrayList<RateBU> rates = new ArrayList<>();
    //endregion

    //region Getters / Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<RateBU> getRates() {
        return rates;
    }

    public void setRates(ArrayList<RateBU> rates) {
        this.rates = rates;
    }
    //endregion

    public ShopBU(int id, String name, String description, String location, ArrayList<RateBU> rates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.rates = rates;
    }
}

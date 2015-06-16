package com.exia.puydufou.BusinessObject;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SpectacleBU implements Serializable
{
    private int id;
    private String name;
    private String description;
    private String picturePath;
    private int duration;
    private Date date;
    private int actorsNumber;
    private ArrayList<PerformanceBU> performances = new ArrayList<>();



    private ArrayList<RateBU> rates = new ArrayList<>();

    public SpectacleBU(int id, String name, String description, String picturePath, int duration, Date date, int actorsNumber, ArrayList<PerformanceBU> performances,ArrayList<RateBU> rates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.picturePath = picturePath;
        this.duration = duration;
        this.date = date;
        this.actorsNumber = actorsNumber;
        this.performances = performances;
        this.rates = rates;

    }

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

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getActorsNumber() {
        return actorsNumber;
    }

    public void setActorsNumber(int actorsNumber) {
        this.actorsNumber = actorsNumber;
    }

    public ArrayList<PerformanceBU> getPerformances() {
        return performances;
    }

    public void setPerformances(ArrayList<PerformanceBU> performances) {
        this.performances = performances;
    }

    public ArrayList<RateBU> getRates() {
        return rates;
    }

    public void setRates(ArrayList<RateBU> rates) {
        this.rates = rates;
    }
}

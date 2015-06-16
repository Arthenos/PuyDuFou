package com.exia.puydufou.BusinessObject;

import android.view.Menu;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by maxim_000 on 16/06/2015.
 */

// implements KvmSerializable
public class RestaurantBU implements Serializable {

    private int id;
    private String name;
    private String description;
    private String location;
    private ArrayList<MenuBU> menus;

    public RestaurantBU(){}

    public RestaurantBU(int id, String name, String description, String location, ArrayList<MenuBU> menus) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.menus = menus;
    }

/*
    public Object getProperty(int arg0) {

        switch(arg0)
        {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return description;
            case 3:
                return location;
            case 4:
                return menus;

        }

        return null;
    }

    public int getPropertyCount() {
        return 5;
    }

    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        switch(index)
        {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Name";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Description";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Location";
                break;
            case 4:
                info.type = PropertyInfo.OBJECT_TYPE;
                info.name = "Menus";
                break;
            default:break;
        }
    }

    public void setProperty(int index, Object value) {
        switch(index)
        {
            case 0:
                id = Integer.parseInt(value.toString());
                break;
            case 1:
                name = value.toString();
                break;
            case 2:
                description = value.toString();
                break;
            case 3:
                location = value.toString();
                break;
            case 4:
      //         TODO:Implmentation des menus


            break;
            default:
                break;
        }
    } */
}

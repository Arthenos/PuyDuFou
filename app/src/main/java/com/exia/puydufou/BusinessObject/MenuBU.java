package com.exia.puydufou.BusinessObject;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by maxim_000 on 16/06/2015.
 */
public class MenuBU implements KvmSerializable {

    //region Attributes
    private int id;
    private String name;
    private String description;
    private float price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    //endregion



    public MenuBU(){}

    public MenuBU(int id, String name, String description, float price) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //region Methods
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
                return price;

        }

        return null;
    }

    public int getPropertyCount() {
        return 4;
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
                info.type = PropertyInfo.OBJECT_CLASS;
                info.name = "Price";
                break;
            default:break;
        }
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

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
                price = Float.parseFloat(value.toString());
                break;
            default:
                break;
        }
    }
    //endregion
}

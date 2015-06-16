package com.exia.puydufou.BusinessObject;

import java.io.Serializable;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

/**
 * Created by maxim_000 on 16/06/2015.
 */
public class RateBU implements /*KvmSerializable*/Serializable
{

    public int id;
    public int rate;
    public String macAddress;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getRate()
    {
        return rate;
    }

    public void setRate(int rate)
    {
        this.rate = rate;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public RateBU(){}

    public RateBU(int id, int rate, String macAddress) {

        this.id = id;
        this.rate = rate;
        this.macAddress = macAddress;
    }


//    public Object getProperty(int arg0) {
//
//        switch(arg0)
//        {
//            case 0:
//                return id;
//            case 1:
//                return rate;
//            case 2:
//                return macAddress;
//        }
//
//        return null;
//    }
//
//    public int getPropertyCount() {
//        return 3;
//    }
//
//    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
//        switch(index)
//        {
//            case 0:
//                info.type = PropertyInfo.INTEGER_CLASS;
//                info.name = "id";
//                break;
//            case 1:
//                info.type = PropertyInfo.INTEGER_CLASS;
//                info.name = "Rate";
//                break;
//            case 2:
//                info.type = PropertyInfo.STRING_CLASS;
//                info.name = "MacAddress";
//                break;
//            default:break;
//        }
//    }
//
//    @Override
//    public String getInnerText() {
//        return null;
//    }
//
//    @Override
//    public void setInnerText(String s) {
//
//    }
//
//    public void setProperty(int index, Object value) {
//        switch(index)
//        {
//            case 0:
//                id = Integer.parseInt(value.toString());
//                break;
//            case 1:
//                rate = Integer.parseInt(value.toString());
//                break;
//            case 2:
//                macAddress = value.toString();
//                break;
//            default:
//                break;
//        }
//    }
}


package de.jkliemann.parkendd;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jkliemann on 28.06.15.
 */
public class City {

    private String name;
    private String id;
    private String data_source;
    private Date last_downloaded;
    private Date last_updated;
    private ArrayList<ParkingSpot> spots = null;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public City(String id, String name){
        this.id = id;
        this.name = name;
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public void setData_source(String url){
        this.data_source = url;
    }

    public void setLast_downloaded(Object date){
        if(date instanceof Date){
            this.last_downloaded = (Date)date;
        }
        if(date instanceof String){
            try {
                this.last_downloaded = dateFormat.parse((String) date);
            }catch (ParseException e){
                e.printStackTrace();
                this.last_downloaded = null;
            }
        }
    }

    public void setLast_updated(Object date){
        if(date instanceof Date){
            this.last_updated = (Date)date;
        }
        if(date instanceof String){
            try{
                this.last_updated = dateFormat.parse((String)date);
            }catch (ParseException e){
                e.printStackTrace();
                this.last_updated = null;
            }
        }
    }

    public void setSpots(ArrayList<ParkingSpot> spots){
        this.spots = spots;
    }

    public String name(){
        return name;
    }

    public String id(){
        return id;
    }

    public String data_source(){
        return data_source;
    }

    public Date last_downloaded(){
        return last_downloaded;
    }

    public Date last_updated(){
        return last_updated;
    }

    public ArrayList<ParkingSpot> spots(){
        return spots;
    }
}

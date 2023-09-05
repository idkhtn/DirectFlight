package com.example.attestationproject1.Database;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.attestationproject1.Model.Airport;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    private static final String DB_NAME="airports.db";
    private static final int DB_VER=1;

    public Database(Context context) {
        super(context, DB_NAME,null, null, DB_VER);
    }

    //function get all airports

    //@SuppressLint("Range")
    public List<Airport> getAirport()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //all column names
        String[] sqlSelect={"Id", "Name", "City", "Country", "Latitude", "Longitude"};
        String tableName="airports";
        //fix limit, orthrow,limit 20
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null,null,null,null);
        List<Airport> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Airport airport = new Airport();
                airport.setId(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                airport.setName(cursor.getString(cursor.getColumnIndexOrThrow("Name")));
                airport.setCity(cursor.getString(cursor.getColumnIndexOrThrow("City")));
                airport.setCountry(cursor.getString(cursor.getColumnIndexOrThrow("Country")));
                airport.setLatitude(cursor.getDouble(cursor.getColumnIndexOrThrow("Latitude")));
                airport.setLongitude(cursor.getDouble(cursor.getColumnIndexOrThrow("Longitude")));

                result.add(airport);
            }while(cursor.moveToNext());
        }
        return result;

    }

    //function get all airport' name
    //@SuppressLint("Range")
    public List<String> getNames()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //all column names
        String[] sqlSelect={ "Name"};
        String tableName="airports";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null,null,null,null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                result.add(cursor.getString(cursor.getColumnIndexOrThrow("Name")));
            }while(cursor.moveToNext());
        }
        return result;
    }

    //function get all airport' countries
    //@SuppressLint("Range")
    public List<String> getCountries()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //all column countries
        String[] sqlSelect={ "Country"};
        String tableName="airports";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null,"COUNTRY",null,null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                result.add(cursor.getString(cursor.getColumnIndexOrThrow("Country")));
            }while(cursor.moveToNext());
        }
        return result;
    }

    //function get airport by name
    //@SuppressLint("Range")
    public List<Airport> getAirportByName(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        //all column names
        String[] sqlSelect={"Id", "Name", "City", "Country", "Latitude", "Longitude"};
        String tableName="airports";

        qb.setTables(tableName);
        //this will query: Select * from Airport(s) where Name LIKE %pattern%
        //if you want to get extract name just change
        // Cursor cursor = qb.query(db, sqlSelect, "Name = ?", new String[]{name},null,null,null);
        Cursor cursor = qb.query(db, sqlSelect, "Name LIKE ?", new String[]{"%"+name+"%"},null,null,null);
        List<Airport> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Airport airport = new Airport();
                airport.setId(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                airport.setName(cursor.getString(cursor.getColumnIndexOrThrow("Name")));
                airport.setCity(cursor.getString(cursor.getColumnIndexOrThrow("City")));
                airport.setCountry(cursor.getString(cursor.getColumnIndexOrThrow("Country")));
                airport.setLatitude(cursor.getDouble(cursor.getColumnIndexOrThrow("Latitude")));
                airport.setLongitude(cursor.getDouble(cursor.getColumnIndexOrThrow("Longitude")));

                result.add(airport);
            }while(cursor.moveToNext());
        }
        return result;
    }


}

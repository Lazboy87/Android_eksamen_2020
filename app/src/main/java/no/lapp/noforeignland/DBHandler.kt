package no.lapp.noforeignland

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object{

        private val DATABASE_NAME = "Places.db"
        private val DATABASE_VERSION = 1


        val PLACES_TABLE_NAME = "PLACES"
        val COLUMN_ID = "PlaceID"
        val COLUMN_PLACENAME = "PlaceName"
        val COLUMN_PLACEDESCRIPTION = "Placedescription"
        val COLUMN_IMAGEURL = "ImageURL"
        val COLUMN_CORDINATEX= "coordinatesX"
        val COLUMN_CORDINATEY= "coordinatesY"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PLACES_TABLE : String = ("CREATE TABLE $PLACES_TABLE_NAME(" +
                "$COLUMN_ID INTEGER PRIMARY KEY,"+
                "$COLUMN_PLACENAME TEXT,"+
                "$COLUMN_PLACEDESCRIPTION TEXT,"+
                "$COLUMN_IMAGEURL TEXT,"+
                "$COLUMN_CORDINATEX DOUBLE,"+
                "$COLUMN_CORDINATEY DOUBLE)")

        db?.execSQL(CREATE_PLACES_TABLE)

    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addPLaces(places:Places){

        val values = ContentValues()
        values.put(COLUMN_ID, places.id)
        values.put(COLUMN_PLACENAME,places.placeName)
        values.put(COLUMN_PLACEDESCRIPTION,places.description)
        values.put(COLUMN_IMAGEURL,places.imageUrl)
        values.put(COLUMN_CORDINATEX,places.cordinatesX)
        values.put(COLUMN_CORDINATEY,places.cordinatesY)

        val db = this.writableDatabase

        db.insert(PLACES_TABLE_NAME, null, values)
        db.close()
    }


//    fun findPlace(placeName: String): Places? {
//        val query =
//            "SELECT * FROM $PLACES_TABLE_NAME WHERE ${COLUMN_PLACENAME} =  \"$placeName\""
//
//        val db = this.writableDatabase
//
//        val cursor = db.rawQuery(query, null)
//
//        var place: Places? = null
//
//        if (cursor.moveToFirst()) {
//            cursor.moveToFirst()
//
//            val id = Integer.parseInt(cursor.getString(0))
//            val name = cursor.getString(1)
//            val description = cursor.getString(2)
//            val imageUrl = cursor.getString(3)
//            val cordinatesX = Integer.parseInt(cursor.getString(4))
//            val cordinatesY = Integer.parseInt(cursor.getString(5))
//
//            place = Places(id, name, description, imageUrl, cordinatesX, cordinatesY)
//            cursor.close()
//        }
//
//        db.close()
//        return place
//    }﻿
}
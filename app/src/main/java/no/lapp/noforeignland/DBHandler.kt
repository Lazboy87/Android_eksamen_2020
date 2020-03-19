package no.lapp.noforeignland

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context,name : String, factory: SQLiteDatabase.CursorFactory, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object{

        private val DATABASE_NAME = "Places.db"
        private val DATABASE_VERSION = 1


        val PLACES_TABLE_NAME = "PLACES"
        val COULUMN_ID = "PlaceID"
        val COULUMN_PLACENAME = "PlaceName"
        val COULUMN_PLACEDESCRIPTION = "Placedescription"
        val COULUMN_CORDINATEX= "coordinatesX"
        val COULUMN_CORDINATEY= "coordinatesY"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PLACES_TABLE : String = ("CREATE TABLE $PLACES_TABLE_NAME(" +
                "$COULUMN_ID INTEGER PRIMARY KEY,"+
                "$COULUMN_PLACENAME TEXT,"+
                "$COULUMN_PLACEDESCRIPTION TEXT,"+
                "$COULUMN_CORDINATEX DOUBLE,"+
                "$COULUMN_CORDINATEY DOUBLE)")

        db?.execSQL(CREATE_PLACES_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
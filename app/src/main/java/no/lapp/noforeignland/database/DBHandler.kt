package no.lapp.noforeignland.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.FontsContract
import android.widget.Toast
import no.lapp.noforeignland.classes.Feature
import no.lapp.noforeignland.classes.PlacesData
import no.lapp.noforeignland.classes.PlacesHolder

class DBHandler(context: Context, name:String,factory: SQLiteDatabase.CursorFactory,version : Int):
    SQLiteOpenHelper(context,DATABASE_NAME,factory,DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "Places"

        private val DATABASE_VERSION = 1

        val PLACES_TABLE_NAME = "Places"
        val COLUMN_NAME = "Name"
        val COLUMN_ID = "id"
        val COLUMN_COORDINATES = "Coordinates"

    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CREATE_PLACES_TABLE: String = ("CREATE TABLE $PLACES_TABLE_NAME(" +
                "$COLUMN_ID LONG PRIMARY KEY," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_COORDINATES DOUBLE)")

        if (db != null) {
            db.execSQL(CREATE_CREATE_PLACES_TABLE)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    fun getPlaces(mCtx: Context): ArrayList<PlacesHolder> {
        val query = "SELECT * FROM $PLACES_TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        val places = ArrayList<PlacesHolder>()

        if (cursor.count == 0){
            Toast.makeText(mCtx,"no records found",Toast.LENGTH_SHORT).show()

        }else{
          while (cursor.moveToNext()){
              val place = PlacesHolder
              place





          }



        }

    }












}
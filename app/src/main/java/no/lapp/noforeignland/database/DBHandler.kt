package no.lapp.noforeignland.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

import no.lapp.noforeignland.classes.PlacesHolder
import java.lang.Exception

class DBHandler(
    context: Context, name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int):
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

        if (cursor.count == 0) {
            Toast.makeText(mCtx, "no records found", Toast.LENGTH_SHORT).show()

        } else {
            while (cursor.moveToNext()) {
                val place = PlacesHolder()
                place.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                place.coordinates = listOf(cursor.getDouble(cursor.getColumnIndex(COLUMN_COORDINATES)))
                place.name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                places.add(place)

            }
            Toast.makeText(mCtx, "${cursor.count.toString()} records found", Toast.LENGTH_SHORT)
                .show()


        }
        cursor.close()
        db.close()
        return places




    }




    fun addPlaces(mCtx: Context, place: PlacesHolder){
        val values=ContentValues()
      values.put(COLUMN_ID,place.id)
        values.put(COLUMN_COORDINATES,place.coordinates)
        values.put(COLUMN_NAME,place.name)
        val db=this.writableDatabase

        try {
            db.insert(PLACES_TABLE_NAME,null,values)
           // db.rawQuery("INSERT INTO $PLACES_TABLE_NAME($COLUMN_ID,$COLUMN_ID,$COLUMN_COORDINATES) Values(?,?)")

            Toast.makeText(mCtx,"place added", Toast.LENGTH_SHORT).show()

        }catch (e: Exception){
            Toast.makeText(mCtx,e.message, Toast.LENGTH_SHORT).show()
        }


    }
}



private fun ContentValues.put(columnCoordinates: String, coordinates: List<Double>) {
    TODO("Not yet implemented")
}



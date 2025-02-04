package no.lapp.noforeignland.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import no.lapp.noforeignland.classes.Feature
import no.lapp.noforeignland.classes.PlacesHolder

class DBHandler(
    context: Context, name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "Places.db"

        private val DATABASE_VERSION = 1

        val PLACES_TABLE_NAME = "Places"

        val COLUMN_ID = "id"
        val COLUMN_NAME = "Name"
        val COLUMN_COORDINATES_X = "CoordinatesX"
        val COLUMN_COORDINATES_Y = "CoordinatesY"

    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_PLACES_TABLE: String = ("CREATE TABLE IF NOT EXISTS $PLACES_TABLE_NAME (" +
                "$COLUMN_ID LONG PRIMARY KEY," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_COORDINATES_X DOUBLE," +
                "$COLUMN_COORDINATES_Y DOUBLE )")

        db?.execSQL(CREATE_PLACES_TABLE)

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun getPlaces(context: Context): ArrayList<PlacesHolder> {
        val query = "SELECT * FROM $PLACES_TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        val places = ArrayList<PlacesHolder>()

        if (cursor.count == 0) {
            println("records found:" + cursor.count)


        } else {
            while (cursor.moveToNext()) {
                val place = PlacesHolder()
                place.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                place.coordinatesX = cursor.getDouble(cursor.getColumnIndex(COLUMN_COORDINATES_X))
                place.coordinatesY = cursor.getDouble(cursor.getColumnIndex(COLUMN_COORDINATES_Y))
                place.name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                places.add(place)

            }
            println("records found:" + cursor.count)


        }
        cursor.close()
        db.close()
        return places


    }


    fun addPlaces(context: Context, placeList: MutableList<Feature>) {
        val db = this.writableDatabase

        db.beginTransaction()
        for (place in placeList){

            val values = ContentValues()
            values.put(COLUMN_ID, place.properties.id)
            val corValue = place.geometry.coordinates
            values.put(COLUMN_COORDINATES_X, corValue[0])
            values.put(COLUMN_COORDINATES_Y, corValue[1])
            values.put(COLUMN_NAME, place.properties.name)
            try {
                db.insertOrThrow(PLACES_TABLE_NAME, null, values)
            } catch (e: Exception) {
                println("Fail to input data")
            }

        }
        db.setTransactionSuccessful()
        db.endTransaction()


    }


    fun getPlacesSearch(context: Context, text: String): ArrayList<PlacesHolder> {

        val query =
            "SELECT * FROM $PLACES_TABLE_NAME " + " WHERE " + COLUMN_NAME + " LIKE '" + text + "%'"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        val places = ArrayList<PlacesHolder>()

        if (cursor.count == 0) {
            println("no RECORDS")


        } else {
            while (cursor.moveToNext()) {
                val place = PlacesHolder()
                place.id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                place.coordinatesX = cursor.getDouble(cursor.getColumnIndex(COLUMN_COORDINATES_X))
                place.coordinatesY = cursor.getDouble(cursor.getColumnIndex(COLUMN_COORDINATES_Y))
                place.name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                places.add(place)
            }
            println(" RECORDS FOUND: " + cursor.count)


        }
        cursor.close()
        db.close()
        return places

    }
}










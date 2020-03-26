package no.lapp.noforeignland

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListPlaces : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_places)

        val recycle: RecyclerView? = findViewById<RecyclerView>(R.id.Recycler)

        if (recycle != null) {
            recycle.layoutManager=LinearLayoutManager(this)
            recycle.adapter=ViewAdapter()
        }






    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finishAffinity();
            deleteDatabase ("Places.db")
            return;



        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }


}
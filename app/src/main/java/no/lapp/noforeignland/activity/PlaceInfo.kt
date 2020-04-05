package no.lapp.noforeignland.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import no.lapp.noforeignland.R


class PlaceInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_info)
    }

    override fun onBackPressed() {
        this.startActivity(Intent(this,
            ListPlaces::class.java))
        finishAffinity();
        return;
    }


}

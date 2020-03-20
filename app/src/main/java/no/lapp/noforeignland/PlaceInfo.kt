package no.lapp.noforeignland

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class PlaceInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_info)






    }

    override fun onBackPressed() {
        this.startActivity(Intent(this,ListPlaces::class.java))
        finishAffinity();
        return;
    }


}

package no.lapp.noforeignland.activity


import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.list_places.*


import no.lapp.noforeignland.R
import no.lapp.noforeignland.adapters.ViewAdapter
import no.lapp.noforeignland.api.ApiListPlaces
import no.lapp.noforeignland.api.OnAPIResultListener
import no.lapp.noforeignland.classes.Feature


class ListPlaces: AppCompatActivity(), OnAPIResultListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_places)


        ApiListPlaces(this).fetchJson()
    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finishAffinity();
            return;

     }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }

    override fun onAPISuccess(placeList: MutableList<Feature>) {
        runOnUiThread {
            val adapter = ViewAdapter(placeList)
            Recycler.adapter = adapter
            Recycler.layoutManager=LinearLayoutManager(this@ListPlaces)
        }

    }


}

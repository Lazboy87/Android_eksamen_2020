package no.lapp.noforeignland.activity


import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list_places.*
import no.lapp.noforeignland.R
import no.lapp.noforeignland.adapters.ViewAdapter
import no.lapp.noforeignland.database.DBHandler


class ListPlaces : AppCompatActivity() {
    private lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_places)

        dbHandler = DBHandler(this, null, null, 1)



        showplacesFromDB()


        Search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }


        })


    }


    private fun filter(text: String) {

        val PlacesList = dbHandler.getPlaces(this)
        var filterlist = dbHandler.getPlacesSearch(this, text)
        println(filterlist)

        runOnUiThread {
            val adapter = ViewAdapter(PlacesList)
            adapter.filterlist(filterlist)
            Recycler.adapter = adapter
            Recycler.layoutManager = LinearLayoutManager(this@ListPlaces)
        }
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


    fun showplacesFromDB() {
        runOnUiThread {


            val PlacesList = dbHandler.getPlaces(this)
            val adapter = ViewAdapter(PlacesList)
            Recycler.adapter = adapter
            Recycler.layoutManager = LinearLayoutManager(this@ListPlaces)

        }
    }


}

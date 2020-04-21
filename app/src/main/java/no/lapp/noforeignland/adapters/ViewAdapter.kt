package no.lapp.noforeignland.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_layout.view.*
import no.lapp.noforeignland.R
import no.lapp.noforeignland.activity.MapsActivity
import no.lapp.noforeignland.activity.PlaceInfo
import no.lapp.noforeignland.classes.PlacesHolder


class ViewAdapter(private var placeList: ArrayList<PlacesHolder>) :
    RecyclerView.Adapter<ViewAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int {
        return placeList.count()
    }

    //search method that updates the Viewadapter after key is pressed. this method gets its variable from another function from Listplaces Avtivity
    fun filterlist(filterlist: MutableList<PlacesHolder>) {
        placeList = filterlist as ArrayList<PlacesHolder>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_layout, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


        val placeNames = placeList.get(position)
        holder.view.PlaceNametxt?.text = placeNames.name

    }

    inner class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


        init {
            view.PlaceNametxt?.setOnClickListener {

                val intent = Intent(view.context, PlaceInfo::class.java)

                val nameValue = placeList.get(position).name
                val id = placeList.get(position).id.toString()


                val corXvalue = placeList.get(position).coordinatesX
                val corYvalue = placeList.get(position).coordinatesY


                val PLACENAME = "placename"
                val CORDINATES_X = "cordinatesX"
                val CORDINATES_Y = "cordinatesY"

                intent.putExtra(CORDINATES_X, corXvalue)
                intent.putExtra(CORDINATES_Y, corYvalue)
                intent.putExtra(PLACENAME, nameValue)
                intent.putExtra("id", id)

                view.context.startActivity(intent)
            }

            view.imageButtonMAP?.setOnClickListener {

                val nameValue = placeList.get(position).name


                val corXvalue = placeList.get(position).coordinatesX
                val corYvalue = placeList.get(position).coordinatesY


                val PLACENAME = "placename"
                val CORDINATES_X = "cordinatesX"
                val CORDINATES_Y = "cordinatesY"


                val intent = Intent(view.context, MapsActivity::class.java)

                intent.putExtra(CORDINATES_X, corXvalue)
                intent.putExtra(CORDINATES_Y, corYvalue)
                intent.putExtra(PLACENAME, nameValue)

                view.context.startActivity(intent)


            }

        }
    }


}






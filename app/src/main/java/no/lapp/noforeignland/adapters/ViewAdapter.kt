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
import no.lapp.noforeignland.classes.Feature


class ViewAdapter(private var placeList: MutableList<Feature>): RecyclerView.Adapter<ViewAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int {
        return placeList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_layout,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val placeNames = placeList.get(position)
        holder.view.PlaceNametxt?.text= placeNames.properties.name

        }

    inner class CustomViewHolder(val view:View):RecyclerView.ViewHolder(view) {


        init {




            view.PlaceNametxt?.setOnClickListener {
                val intent = Intent(view.context, PlaceInfo::class.java)
                val nameValue = placeList.get(position).properties.name
                val id = placeList.get(position).properties.id

                intent.putExtra("placename",nameValue)
                intent.putExtra("id",id)
                view.context.startActivity(intent)
            }

            view.imageButtonMAP?.setOnClickListener {

                val place = placeList.get(position)
                val nameValue = placeList.get(position).properties.name
                val corValue = placeList.get(position).geometry.coordinates

                val corXvalue = corValue[0]
                val corYvalue = corValue[1]


                val PLACENAME = "placename"
                val CORDINATES_X = "cordinatesX"
                val CORDINATES_Y = "cordinatesY"


                val intent = Intent(view.context, MapsActivity::class.java)

                intent.putExtra(CORDINATES_X,corXvalue)
                intent.putExtra(CORDINATES_Y,corYvalue)
                intent.putExtra(PLACENAME,nameValue)
                println(corValue)
                view.context.startActivity(intent)


            }

        }
    }


}






package no.lapp.noforeignland

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_layout.view.*

class ViewAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val placeNames = listOf("FIRST PLACE","Second","3rd","FIRST PLACE","Second","3rd","FIRST PLACE","Second","3rd")

    override fun getItemCount(): Int {
        return placeNames.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_layout,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val placeNames = placeNames.get(position)
        holder.view.PlaceNametxt?.text= placeNames

    }
}

class CustomViewHolder(val view:View):RecyclerView.ViewHolder(view){

}
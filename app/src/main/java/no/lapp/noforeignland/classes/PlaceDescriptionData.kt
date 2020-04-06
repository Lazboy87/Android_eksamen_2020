package no.lapp.noforeignland.classes


import com.google.gson.annotations.SerializedName

data class PlaceDescriptionData(
    val place: Place,
    val snapshots: List<Any>
)
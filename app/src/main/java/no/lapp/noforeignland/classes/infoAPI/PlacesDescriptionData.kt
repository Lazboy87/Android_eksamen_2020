package no.lapp.noforeignland.classes.infoAPI


import com.google.gson.annotations.SerializedName

data class PlacesDescriptionData(
    val place: Place,
    val snapshots: List<Snapshot>
)
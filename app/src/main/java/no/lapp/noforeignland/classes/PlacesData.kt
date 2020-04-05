package no.lapp.noforeignland.classes


import com.google.gson.annotations.SerializedName

data class PlacesData(
@SerializedName("Feature")
    val features: List<Feature>,
    val type: String
)
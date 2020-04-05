package no.lapp.noforeignland.classes


import com.google.gson.annotations.SerializedName

data class Geometry(
    val coordinates: List<Double>,
    val type: String
)
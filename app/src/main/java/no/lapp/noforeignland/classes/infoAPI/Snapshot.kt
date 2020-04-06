package no.lapp.noforeignland.classes.infoAPI


import com.google.gson.annotations.SerializedName

data class Snapshot(
    val reason: String,
    val time: Long
)
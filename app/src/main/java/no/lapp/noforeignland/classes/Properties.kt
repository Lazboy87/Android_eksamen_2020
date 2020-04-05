package no.lapp.noforeignland.classes


import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String
)
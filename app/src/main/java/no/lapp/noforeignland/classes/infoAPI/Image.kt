package no.lapp.noforeignland.classes.infoAPI


import com.google.gson.annotations.SerializedName

data class Image(
    val caption: String,
    val height: Int,
    val id: Long,
    val likes: List<Long>,
    val servingUrl: String,
    val uploadedByUserDisplayName: String,
    val uploadedByUserId: Long,
    val uploadedDate: Long,
    val width: Int
)
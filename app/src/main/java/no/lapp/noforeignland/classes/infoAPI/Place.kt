package no.lapp.noforeignland.classes.infoAPI


data class Place(
    val addedBy: String,
    val addedById: Any,
    val allowsExternalContractors: Boolean,
    val banner: String,
    val blogCount: Int,
    val canStayOnOwnBoat: Boolean,
    val canWorkOnOwnBoat: Boolean,
    val col: String,
    val comments: String,
    val countryCode: String,
    val icon: String,
    val id: Long,
    val images:List<Image>,
    val lat: Double,
    val lon: Double,
    val name: String,
    val reviews: List<Any>,
    val stars: Int,
    val type: String,
    val updatedBy: String,
    val updatedById: Long,
    val updatedMs: Long,
    val winterCommunity: Boolean
)
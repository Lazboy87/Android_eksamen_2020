package no.lapp.noforeignland.classes.infoAPI


import com.google.gson.annotations.SerializedName

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

    val dieselPriceUpdatedMs: Long,
    val externalLink1: String,
    val externalLink2: String,
    val externalLinkDescription1: String,
    val externalLinkDescription2: String,
    val gasolinePrice: Int,
    val gasolinePriceUpdatedMs: Long,
    val icon: String,
    val id: Long,
    val images:List<Image>,
    val lat: Double,
    val lon: Double,
    val mapboxIcon: String,
    val maxLiftWeightTonnes: Int,
    val meta: Meta,
    val name: String,
    val priceBandHighSeason: String,
    val priceBandLowSeason: String,
    val protectionFrom: String,
    val reviews: List<Any>,
    val stars: Int,
    val type: String,
    val updatedBy: String,
    val updatedById: Long,
    val updatedMs: Long,
    val winterCommunity: Boolean
)
package no.lapp.noforeignland.classes


import com.google.gson.annotations.SerializedName

data class Place(
    val addedBy: String,
    val addedById: Long,
    val addedMs: Long,
    val allowsExternalContractors: Boolean,
    val banner: String,
    val blogCount: Int,
    val canStayOnOwnBoat: Boolean,
    val canWorkOnOwnBoat: Boolean,
    val col: String,
    val comments: String,
    val countryCode: String,
    val dieselPrice: Int,
    val dieselPriceUpdatedMs: Long,
    val externalLink1: String,
    val externalLink2: String,
    val externalLinkDescription1: String,
    val externalLinkDescription2: String,
    val gasolinePrice: Int,
    val gasolinePriceUpdatedMs: Long,
    val icon: String,
    val id: Long,
    val images: List<Any>,
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
    val updatedById: Any,
    val updatedMs: Int,
    val winterCommunity: Boolean
)
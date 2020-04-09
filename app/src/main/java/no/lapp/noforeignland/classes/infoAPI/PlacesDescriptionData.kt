package no.lapp.noforeignland.classes.infoAPI


data class PlacesDescriptionData(
    val place: Place,
    val snapshots: List<Snapshot>
)
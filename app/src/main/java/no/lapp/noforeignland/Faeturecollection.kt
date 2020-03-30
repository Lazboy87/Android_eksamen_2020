package no.lapp.noforeignland


class Faeturecollection(val type: String?, val features: List<Features>) {

             class Features(val type: String?, val properties: List<Properties>,val geometry : List<Geometry>){


                         class Properties(
                        val name: String?,
                        val icon: String?,
                        val id: String?
                                        )

             class Geometry(val type: String?,
                            val coordinates: String? )

             }
}


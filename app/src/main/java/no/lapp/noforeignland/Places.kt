package no.lapp.noforeignland

class Places {
    var id =0
    var placeName = ""
    var description=""
    var imageUrl=""
    var cordinatesX= 0
    var cordinatesY= 0

    constructor(
        id: Int,
        placeName:String,
        description:String,
        imageUrl:String,
        cordinatesX: Int,
        cordinatesY: Int
    ){
        this.id = id
        this.placeName=placeName
        this.description=description
        this.imageUrl=imageUrl
        this.cordinatesX= cordinatesX
        this.cordinatesY= cordinatesY
}
}
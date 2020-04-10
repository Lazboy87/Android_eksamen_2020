package no.lapp.noforeignland.api


import no.lapp.noforeignland.classes.Feature

interface  OnAPIResultListener {

 fun onAPISuccess(placeList : MutableList<Feature>);



}

package no.lapp.noforeignland.Api

import no.lapp.noforeignland.classes.Feature

interface OnAPIResultListener {

 fun onAPISuccess(placeList : MutableList<Feature>);



}

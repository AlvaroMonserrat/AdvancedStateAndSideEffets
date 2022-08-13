package com.rrat.advancedstateandsideeffets.data

data class City(
    val name: String,
    val country: String,
    val latitude: String,
    val longitude: String
){
    val nameToDisplay = "$name, $country"
}

package com.rrat.advancedstateandsideeffets.data

interface Repository {
    fun getDestinations() : List<ExploreModel>
    fun getHotels() : List<ExploreModel>
    fun getRestaurants() : List<ExploreModel>

    fun getDestination(cityName: String): ExploreModel?
}
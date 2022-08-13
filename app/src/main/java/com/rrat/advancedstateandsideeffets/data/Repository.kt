package com.rrat.advancedstateandsideeffets.data

import com.rrat.advancedstateandsideeffets.data.ExploreModel

interface Repository {
    fun getDestinations() : List<ExploreModel>
    fun getHotels() : List<ExploreModel>
    fun getRestaurants() : List<ExploreModel>

    fun getDestination(cityName: String): ExploreModel?
}
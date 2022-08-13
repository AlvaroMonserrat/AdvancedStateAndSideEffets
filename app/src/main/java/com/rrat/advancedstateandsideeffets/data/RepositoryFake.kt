package com.rrat.advancedstateandsideeffets.data

class RepositoryFake() : Repository {
    override fun getDestinations(): List<ExploreModel> {
        return listOf(
            ExploreModel(
                City("Santiago", "Chile", "100", "200"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "100", "200"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "100", "200"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "100", "200"),
                "This is an example",
                "image/1"
            )
        )
    }

    override fun getHotels(): List<ExploreModel> {
        return listOf(
            ExploreModel(
                City("Santiago", "Chile", "100", "200"),
                "This is an example hotel",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "100", "200"),
                "This is an example hotel",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "100", "200"),
                "This is an example hotel",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "100", "200"),
                "This is an example hotel",
                "image/1"
            )
        )
    }

    override fun getRestaurants(): List<ExploreModel> {
        return listOf(
            ExploreModel(
                City("Santiago", "Chile", "100", "200"),
                "This is an example restaurant",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "100", "200"),
                "This is an example restaurant",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "100", "200"),
                "This is an example restaurant",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "100", "200"),
                "This is an example restaurant",
                "image/1"
            )
        )
    }

    override fun getDestination(cityName: String): ExploreModel? {
        val destinations = listOf(
            ExploreModel(
                City("Santiago", "Chile", "100", "200"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "100", "200"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "100", "200"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "100", "200"),
                "This is an example",
                "image/1"
            )
        )

        return destinations.firstOrNull(){
            it.city.name == cityName
        }
    }

}
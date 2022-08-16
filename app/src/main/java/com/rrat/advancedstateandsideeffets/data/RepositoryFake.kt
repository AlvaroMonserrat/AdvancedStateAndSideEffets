package com.rrat.advancedstateandsideeffets.data


private const val DEFAULT_IMAGE_WIDTH = "250"

class RepositoryFake() : Repository {
    override fun getDestinations(): List<ExploreModel> {
        return listOf(
            ExploreModel(
                City("Santiago", "Chile", "40.416775", "-3.703790"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "40.416775", "-3.703790"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "40.416775", "-3.703790"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "40.416775", "-3.703790"),
                "This is an example",
                "image/1"
            ),
            ExploreModel(
                city = NAPLES,
                description = "1286 Restaurants",
                imageUrl = "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&auto=format&fit=crop&w=$DEFAULT_IMAGE_WIDTH"
            ),
            ExploreModel(
                city = DALLAS,
                description = "2241 Restaurants",
                imageUrl = "https://images.unsplash.com/photo-1495749388945-9d6e4e5b67b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=$DEFAULT_IMAGE_WIDTH"
            ),
            ExploreModel(
                city = CORDOBA,
                description = "876 Restaurants",
                imageUrl = "https://images.unsplash.com/photo-1562625964-ffe9b2f617fc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=250&q=$DEFAULT_IMAGE_WIDTH"
            ),
            ExploreModel(
                city = MADRID,
                description = "5610 Restaurants",
                imageUrl = "https://images.unsplash.com/photo-1515443961218-a51367888e4b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=$DEFAULT_IMAGE_WIDTH"
            ),
            ExploreModel(
                city = MALDIVAS,
                description = "1286 Restaurants",
                imageUrl = "https://images.unsplash.com/flagged/photo-1556202256-af2687079e51?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=$DEFAULT_IMAGE_WIDTH"
            ),
            ExploreModel(
                city = ASPEN,
                description = "2241 Restaurants",
                imageUrl = "https://images.unsplash.com/photo-1542384557-0824d90731ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=$DEFAULT_IMAGE_WIDTH"
            ),
            ExploreModel(
                city = BALI,
                description = "876 Restaurants",
                imageUrl = "https://images.unsplash.com/photo-1567337710282-00832b415979?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=$DEFAULT_IMAGE_WIDTH"
            )
        )
    }

    override fun getHotels(): List<ExploreModel> {
        return listOf(
            ExploreModel(
                City("Santiago", "Chile", "40.416775", "-3.703790"),
                "This is an example hotel",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "40.416775", "-3.703790"),
                "This is an example hotel",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "40.416775", "-3.703790"),
                "This is an example hotel",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "40.416775", "-3.703790"),
                "This is an example hotel",
                "image/1"
            )
        )
    }

    override fun getRestaurants(): List<ExploreModel> {
        return listOf(
            ExploreModel(
                City("Santiago", "Chile", "40.416775", "-3.703790"),
                "This is an example restaurant",
                "image/1"
            ),
            ExploreModel(
                City("Buenos Aires", "Argentina", "40.416775", "-3.703790"),
                "This is an example restaurant",
                "image/1"
            ),
            ExploreModel(
                City("Lima", "Peru", "40.416775", "-3.703790"),
                "This is an example restaurant",
                "image/1"
            ),
            ExploreModel(
                City("La Paz", "Bolivia", "40.416775", "-3.703790"),
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
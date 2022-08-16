package com.rrat.advancedstateandsideeffets.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.rrat.advancedstateandsideeffets.home.section.ExploreSection

@Composable
fun FrontContent(
    tabSelected: RaffleScreen,
    viewModel: MainViewModel
){
    when(tabSelected){
        RaffleScreen.Active -> ExploreSection(
            modifier = Modifier,
            title = "Showing Active ",
            exploreList = viewModel.suggestedDestinations.collectAsState().value
        )
        RaffleScreen.Paused -> ExploreSection(
            title = "Raffle Paused",
            exploreList = viewModel.hotels
        )
        RaffleScreen.Draw -> ExploreSection(
            title = "Start to Draw",
            exploreList = viewModel.restaurants
        )
    }
}
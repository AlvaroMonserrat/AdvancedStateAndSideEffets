package com.rrat.advancedstateandsideeffets.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.home.section.ExploreSection

@Composable
fun FrontContent(
    tabSelected: RaffleScreen,
    viewModel: MainViewModel,
    onItemClicked: (ExploreModel)->Unit
){
    when(tabSelected){
        RaffleScreen.Active -> ExploreSection(
            modifier = Modifier,
            title = "Showing Active ",
            exploreList = viewModel.suggestedDestinations.collectAsState().value,
            onItemClicked = onItemClicked
        )
        RaffleScreen.Paused -> ExploreSection(
            title = "Raffle Paused",
            exploreList = viewModel.hotels,
            onItemClicked = onItemClicked
        )
        RaffleScreen.Draw -> ExploreSection(
            title = "Start to Draw",
            exploreList = viewModel.restaurants,
            onItemClicked = onItemClicked
        )
    }
}
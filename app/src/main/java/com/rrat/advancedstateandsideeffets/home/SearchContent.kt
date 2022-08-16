package com.rrat.advancedstateandsideeffets.home

import androidx.compose.runtime.Composable
import com.rrat.advancedstateandsideeffets.home.screens.active.ActiveSearchContent
import com.rrat.advancedstateandsideeffets.home.screens.draw.DrawSearchContent
import com.rrat.advancedstateandsideeffets.home.screens.paused.PausedSearchContent


@Composable
fun SearchContent(
    tabSelected: RaffleScreen,
    viewModel: MainViewModel,
    onPeopleChanged: (Int) -> Unit
){
    when(tabSelected){
        RaffleScreen.Active -> ActiveSearchContent(
            onPeopleChanged = onPeopleChanged,
            onToDestinationChanged = {viewModel.toDestinationChanged(it)}
        )
        RaffleScreen.Paused -> PausedSearchContent(
            onPeopleChanged = onPeopleChanged
        )
        RaffleScreen.Draw -> DrawSearchContent(
            onPeopleChanged = onPeopleChanged
        )
    }
}
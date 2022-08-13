package com.rrat.advancedstateandsideeffets.home

import androidx.compose.runtime.Composable
import com.rrat.advancedstateandsideeffets.home.screens.active.ActiveSearchContent
import com.rrat.advancedstateandsideeffets.home.screens.draw.DrawSearchContent
import com.rrat.advancedstateandsideeffets.home.screens.paused.PausedSearchContent


@Composable
fun SearchContent(
    tabSelected: RaffleScreen
){
    when(tabSelected){
        RaffleScreen.Active -> ActiveSearchContent()
        RaffleScreen.Paused -> PausedSearchContent()
        RaffleScreen.Draw -> DrawSearchContent()
    }
}
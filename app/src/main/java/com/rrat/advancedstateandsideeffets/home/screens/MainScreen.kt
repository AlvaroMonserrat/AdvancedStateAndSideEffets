package com.rrat.advancedstateandsideeffets.home.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.home.AdvancedStateHome


@Composable
fun MainScreen(
    onExploreItemClicked: (ExploreModel)->Unit
){
    Surface(color = MaterialTheme.colors.primary) {
        var showLandingScreen by remember {
            mutableStateOf(true)
        }

        if(showLandingScreen){
            LandingScreen() {
                showLandingScreen = false
            }
        }else{
            AdvancedStateHome(onItemClicked=onExploreItemClicked)
        }
    }
}
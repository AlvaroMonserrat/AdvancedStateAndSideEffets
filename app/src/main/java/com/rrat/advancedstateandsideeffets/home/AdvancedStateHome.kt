package com.rrat.advancedstateandsideeffets.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.ui.componets.BasicDrawer
import kotlinx.coroutines.launch


enum class RaffleScreen {
    Active, Paused, Draw
}

@Composable
fun AdvancedStateHome(
    modifier: Modifier = Modifier,
    onItemClicked: (ExploreModel)->Unit
){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState=scaffoldState,
        modifier = modifier.statusBarsPadding(),
        drawerContent = {
                BasicDrawer()
        }
    ) {
        padding->
        AdvancedStateContent(
            modifier = modifier.padding(padding),
            openDrawer = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            },
            onItemClicked = onItemClicked
        )
    }
}

@Preview
@Composable
fun AdvancedStateHomePreview(){
    AdvancedStateHome(){}
}
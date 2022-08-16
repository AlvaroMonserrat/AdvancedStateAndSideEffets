package com.rrat.advancedstateandsideeffets.home

import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.ui.componets.HomeTabBar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AdvancedStateContent(
    modifier: Modifier = Modifier,
    openDrawer: ()->Unit,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onItemClicked: (ExploreModel)->Unit
){

    val onPeopleChanged: (Int)->Unit = { viewModel.updatePeople(it) }
    var tabSelected by remember { mutableStateOf(RaffleScreen.Active)}

    BackdropScaffold(
        modifier=modifier,
        //scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        //frontLayerScrimColor = Color.Unspecified,
        appBar = { HomeTabBar(
            openDrawer = openDrawer,
            tabSelected = tabSelected,
            onTabSelected = {tabSelected = it}
        ) },
        backLayerContent = {
            SearchContent(
                tabSelected = tabSelected,
                viewModel = viewModel,
                onPeopleChanged = onPeopleChanged
            )
        },
        frontLayerContent = {
            FrontContent(
                tabSelected = tabSelected,
                viewModel = viewModel,
                onItemClicked = onItemClicked
            )
        }
    )
}

@Preview
@Composable
fun AdvancedStateContentPreview()
{

}
package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.home.RaffleScreen
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme


@Composable
fun HomeTabBar(
    modifier: Modifier = Modifier,
    openDrawer: ()->Unit,
    tabSelected: RaffleScreen,
    onTabSelected: (RaffleScreen) ->Unit
){
    BasicTabBar(
        modifier=modifier,
        openDrawer=openDrawer
    ) {
        tabBarModifier->
        BasicTabs(
            modifier = tabBarModifier.padding(bottom=16.dp),
            titles = RaffleScreen.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = onTabSelected
        )
    }

}

@Preview(showBackground = true, widthDp = 350, heightDp = 600)
@Composable
fun HomeTabBarPreview(){
    AdvancedStateAndSideEffetsTheme() {
        BasicTabBar(
            openDrawer = {}
        ){
                tabBarModifier->
            BasicTabs(
                modifier = tabBarModifier,
                titles = RaffleScreen.values().map { it.name },
                tabSelected = RaffleScreen.Active,
                onTabSelected = {}
            )
        }
    }
}
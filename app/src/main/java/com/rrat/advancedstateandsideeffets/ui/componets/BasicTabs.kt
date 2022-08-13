package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.os.ConfigurationCompat
import com.rrat.advancedstateandsideeffets.home.RaffleScreen
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme


@Composable
fun BasicTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: RaffleScreen,
    onTabSelected: (RaffleScreen)->Unit
){
    TabRow(
        modifier = modifier,
        selectedTabIndex = tabSelected.ordinal,
        contentColor = MaterialTheme.colors.onSurface,
        indicator = {},
        divider = {}
    ) {
        titles.forEachIndexed{
            index, title->

            val selected = index == tabSelected.ordinal
            var textModifier =Modifier.padding(vertical = 4.dp, horizontal = 8.dp)

            if(selected){
                textModifier = Modifier
                    .border(BorderStroke(2.dp, Color.White), RoundedCornerShape(8.dp))
                    .then(textModifier)
            }

            Tab(
                selected = selected,
                onClick = { onTabSelected(RaffleScreen.values()[index]) }) {
                Text(
                    modifier = textModifier,
                    text = title.uppercase(
                        ConfigurationCompat.getLocales(LocalConfiguration.current)[0]!!
                    ))
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 600)
@Composable
fun BasicTabsPreview(){
    AdvancedStateAndSideEffetsTheme() {
        BasicTabs(modifier = Modifier,
            listOf("A", "B", "C"),
            RaffleScreen.Active,
            onTabSelected = {}
        )
    }
}
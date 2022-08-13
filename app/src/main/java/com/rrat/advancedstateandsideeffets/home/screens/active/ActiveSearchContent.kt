package com.rrat.advancedstateandsideeffets.home.screens.active

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rrat.advancedstateandsideeffets.ui.componets.PeopleUserInput
import com.rrat.advancedstateandsideeffets.ui.componets.Search
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme


@Composable
fun ActiveSearchContent(){
    Search {
        PeopleUserInput(
            titleSuffix = ", Economy"
        )
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 600)
@Composable
fun ActiveSearchContentPreview(){
    AdvancedStateAndSideEffetsTheme() {
        ActiveSearchContent()
    }
}
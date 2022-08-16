package com.rrat.advancedstateandsideeffets.home.screens.paused

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rrat.advancedstateandsideeffets.ui.componets.PeopleUserInput
import com.rrat.advancedstateandsideeffets.ui.componets.Search
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme

@Composable
fun PausedSearchContent(
    onPeopleChanged: (Int)->Unit
){
    Search {
        PeopleUserInput(
            onPeopleChanged=onPeopleChanged
        )
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 600)
@Composable
fun PausedSearchContentPreview(){
    AdvancedStateAndSideEffetsTheme() {
        PausedSearchContent(){}
    }
}
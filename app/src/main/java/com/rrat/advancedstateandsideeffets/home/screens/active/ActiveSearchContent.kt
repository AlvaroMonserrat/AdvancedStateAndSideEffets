package com.rrat.advancedstateandsideeffets.home.screens.active

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.ui.componets.*
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme


@Composable
fun ActiveSearchContent(
    onPeopleChanged: (Int)->Unit,
    onToDestinationChanged: (String)->Unit
){
    Search {
        PeopleUserInput(
            titleSuffix = ", Economy",
            onPeopleChanged = onPeopleChanged,
        )

        Spacer(modifier = Modifier.height(8.dp))
        FromDestination()
        Spacer(modifier = Modifier.height(8.dp))
        ToDestinationUserInput(onToDestinationChanged=onToDestinationChanged)
        Spacer(modifier = Modifier.height(8.dp))
        DatesUserInput()
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 600)
@Composable
fun ActiveSearchContentPreview(){
    AdvancedStateAndSideEffetsTheme() {
        ActiveSearchContent({}){}
    }
}
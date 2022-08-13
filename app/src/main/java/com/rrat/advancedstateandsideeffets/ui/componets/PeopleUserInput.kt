package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


@Composable
fun PeopleUserInput(
    titleSuffix: String = ""
){
    Column() {
        BasicUserInput(
            text = "user $titleSuffix"
        )
    }
}
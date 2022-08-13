package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Search(
    content: @Composable ()->Unit
){
    Column(
        Modifier.padding(start = 24.dp, top=0.dp, end = 24.dp, bottom = 12.dp)
    ) {
        content()
    }
}
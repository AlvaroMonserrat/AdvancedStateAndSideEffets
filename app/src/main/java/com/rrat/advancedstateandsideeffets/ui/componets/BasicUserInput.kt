package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.annotation.DrawableRes
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun BasicUserInput(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()->Unit = {},
    caption: String? = null,
    @DrawableRes vectorImageId: Int? = null,
    tint: Color = LocalContentColor.current
){
    UserInput(
        modifier=modifier,
        onClick=onClick,
        caption = caption,
        vectorImageId = vectorImageId,
        tintIcon = { text.isNotBlank() },
        tint = tint
    ){
        Text(text = text, style = MaterialTheme.typography.body1.copy(color = tint))
    }
}
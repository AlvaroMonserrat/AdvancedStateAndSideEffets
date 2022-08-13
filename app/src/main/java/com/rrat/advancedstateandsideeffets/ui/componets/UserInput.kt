package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.R
import com.rrat.advancedstateandsideeffets.ui.theme.captionTextStyle


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun UserInput(
  modifier: Modifier = Modifier,
  onClick: ()->Unit = {},
  caption: String? = null,
  showCaption: ()->Boolean = {true},
  @DrawableRes vectorImageId: Int? = null,
  tintIcon: ()->Boolean,
  tint: Color = LocalContentColor.current,
  content: @Composable ()->Unit
){
    Surface(
        modifier = modifier,
        onClick = onClick,
        color = MaterialTheme.colors.primaryVariant
    ) {


        Row(Modifier.padding(all = 12.dp)) {
            if(vectorImageId != null){
                Icon(
                    modifier = Modifier.size(24.dp, 24.dp),
                    painter = painterResource(id = vectorImageId),
                    tint = if(tintIcon()) tint else Color(0x80FFFFFF),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            if(caption != null && showCaption()){
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = caption,
                    style = (captionTextStyle).copy(color = tint)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Row(
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {
                content()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun UserInputPreview(){
    MaterialTheme() {
        UserInput(
            vectorImageId = R.drawable.ic_raffle,
            tintIcon = {false},
            caption = "Caption",
            showCaption = {true}
        ){
            Text(text="Example", style = MaterialTheme.typography.body1)
        }
    }
}
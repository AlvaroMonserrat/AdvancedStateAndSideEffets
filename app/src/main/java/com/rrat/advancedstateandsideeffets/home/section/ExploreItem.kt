package com.rrat.advancedstateandsideeffets.home.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.R
import com.rrat.advancedstateandsideeffets.data.ExploreModel


@Composable
fun ExploreItem(
    modifier: Modifier = Modifier,
    item: ExploreModel,
    onItemClicked: (ExploreModel)->Unit
){
    Row(
        modifier = modifier
            .padding(top = 12.dp, bottom = 12.dp)
            .clickable { onItemClicked(item)}
    ) {
        Surface(Modifier.size(width = 60.dp, height = 60.dp), RoundedCornerShape(4.dp)) {
            Box{
                //val painter = rememberAsyncImagePainter()
                Image(
                    painter = painterResource(id = R.drawable.cuadro),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.width(24.dp))

        Column() {
            Text(
                text = item.city.nameToDisplay,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))

            
            Text(
                text = item.description
            )
        }

    }
}
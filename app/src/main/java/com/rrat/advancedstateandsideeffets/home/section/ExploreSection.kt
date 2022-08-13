package com.rrat.advancedstateandsideeffets.home.section

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.data.RepositoryFake

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    title: String,
    exploreList: List<ExploreModel> = emptyList()
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White,
    ) {
        Column(
            modifier=Modifier.padding(start = 24.dp, top = 20.dp, end=24.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.caption
            )
            Spacer(modifier = Modifier.height(8.dp))

            ExploreList(
                modifier = Modifier,
                exploreList = exploreList
            )
        }
    }
}
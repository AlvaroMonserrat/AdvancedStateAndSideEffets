package com.rrat.advancedstateandsideeffets.home.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rrat.advancedstateandsideeffets.data.ExploreModel


@Composable
fun ExploreList(
    modifier: Modifier = Modifier,
    exploreList: List<ExploreModel>
){
    LazyColumn(modifier = modifier){
        items(exploreList){
            exploreItem->
            Column(Modifier.fillParentMaxWidth()) {
                ExploreItem(
                    modifier = Modifier.fillParentMaxWidth(),
                    item = exploreItem
                )
            }
        }
        item {
            //Spacer(modifier = Modifier.navigationB)
        }
    }
}
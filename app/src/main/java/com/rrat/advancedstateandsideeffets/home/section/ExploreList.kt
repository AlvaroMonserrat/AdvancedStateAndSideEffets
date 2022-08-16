package com.rrat.advancedstateandsideeffets.home.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.ui.theme.advanced_divider_color


@Composable
fun ExploreList(
    modifier: Modifier = Modifier,
    exploreList: List<ExploreModel>,
    onItemClicked: (ExploreModel)->Unit,
    listState: LazyListState = rememberLazyListState()
){
    LazyColumn(modifier = modifier){
        items(exploreList){
            exploreItem->
            Column(Modifier.fillParentMaxWidth()) {
                ExploreItem(
                    modifier = Modifier.fillParentMaxWidth(),
                    item = exploreItem,
                    onItemClicked = onItemClicked
                )
                Divider(color=advanced_divider_color)
            }
        }
        item {
            //Spacer(modifier = Modifier.navigationB)
        }
    }
}
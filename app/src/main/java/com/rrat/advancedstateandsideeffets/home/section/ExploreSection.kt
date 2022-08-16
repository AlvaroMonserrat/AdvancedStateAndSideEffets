package com.rrat.advancedstateandsideeffets.home.section

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import kotlinx.coroutines.launch

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    title: String,
    exploreList: List<ExploreModel> = emptyList(),
    onItemClicked: (ExploreModel)->Unit
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
            Box(Modifier.weight(1f)){

                val listState = rememberLazyListState()

                ExploreList(
                    modifier = Modifier,
                    exploreList = exploreList,
                    onItemClicked = onItemClicked,
                    listState = listState
                )

                // Show the button if the first visible item is past
                // the first item. We use a remembered derived state to
                // minimize unnecessary compositions
                val showButton = remember{
                    derivedStateOf {
                        listState.firstVisibleItemIndex > 0
                    }
                }
                if (showButton.value){
                    val coroutineScope = rememberCoroutineScope()
                    FloatingActionButton(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .navigationBarsPadding()
                            .padding(bottom = 8.dp),
                        onClick = {
                            coroutineScope.launch {
                                listState.scrollToItem(0)
                            }
                        }
                    ) {
                        Text("Up!")
                    }
                }
            }

        }
    }
}
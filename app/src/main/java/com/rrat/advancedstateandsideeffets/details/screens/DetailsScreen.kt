package com.rrat.advancedstateandsideeffets.details.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rrat.advancedstateandsideeffets.base.Result
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.details.DetailsUiState
import com.rrat.advancedstateandsideeffets.details.DetailsViewModel


@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = viewModel(),
    onErrorLoading: ()->Unit

){

    val uiState by produceState(initialValue = DetailsUiState(isLoading = true)){
        // In a coroutine, this can call suspend functions or move
        // the computation to different Dispatchers
        val cityDetailsResult = viewModel.cityDetails
        value = if(cityDetailsResult is Result.Success<ExploreModel>){
            DetailsUiState(cityDetailsResult.data)
        }else{
            DetailsUiState(throwError = true)
        }
    }

    when {
        uiState.cityDetails != null -> {
            DetailsContent(
                modifier = modifier.fillMaxSize(),
                uiState.cityDetails!!
            )
        }
        uiState.isLoading -> {
            Box(modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        else -> {
            onErrorLoading()
        }

    }
}
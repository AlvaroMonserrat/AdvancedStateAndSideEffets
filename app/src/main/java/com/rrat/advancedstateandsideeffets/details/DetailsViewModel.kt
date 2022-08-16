package com.rrat.advancedstateandsideeffets.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rrat.advancedstateandsideeffets.base.Result
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val destinationsRepository: Repository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val cityName = savedStateHandle.get<String>(KEY_ARG_DETAILS_CITY_NAME)!!

    val cityDetails: Result<ExploreModel>
    get() {
        val destination = destinationsRepository.getDestination(cityName)
        return if (destination != null){
            Result.Success(destination)
        }else{
           Result.Error(IllegalArgumentException("City doesn't exist"))
        }
    }
}
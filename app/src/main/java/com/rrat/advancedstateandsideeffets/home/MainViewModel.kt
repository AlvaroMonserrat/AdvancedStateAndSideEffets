package com.rrat.advancedstateandsideeffets.home

import androidx.lifecycle.ViewModel
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val hotels: List<ExploreModel> = repository.getHotels()
    val restaurants: List<ExploreModel> = repository.getRestaurants()

    private val _suggestedDestinations = MutableStateFlow<List<ExploreModel>>(emptyList())

    val suggestedDestinations: StateFlow<List<ExploreModel>>
        get() = _suggestedDestinations

    init {
        _suggestedDestinations.value = repository.getDestinations()
    }
}
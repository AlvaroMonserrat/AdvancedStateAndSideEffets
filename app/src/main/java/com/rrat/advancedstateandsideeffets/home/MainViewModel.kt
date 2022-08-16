package com.rrat.advancedstateandsideeffets.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.data.Repository
import com.rrat.advancedstateandsideeffets.ui.componets.MAX_PEOPLE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import kotlin.random.Random

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

    fun updatePeople(people: Int){
        viewModelScope.launch {
            if(people > MAX_PEOPLE){
                _suggestedDestinations.value = emptyList()
            }else{
                val newDestinations = withContext(Dispatchers.Default){
                    repository.getDestinations().shuffled(Random(people * (1..100).shuffled().first()))
                }

                _suggestedDestinations.value = newDestinations
            }
        }
    }

    fun toDestinationChanged(newDestination: String){
        viewModelScope.launch {
            val newDestinations = withContext(Dispatchers.Default){
                repository.getDestinations().filter { it.city.nameToDisplay.contains(newDestination) }
            }

            _suggestedDestinations.value=newDestinations
        }
    }



}
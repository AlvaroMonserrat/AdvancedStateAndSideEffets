package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter

const val MAX_PEOPLE = 4

enum class PeopleUserInputAnimationState {Valid, Invalid}

class PeopleUserInputState{

    var people by mutableStateOf(1)
        private set

    val animationState: MutableTransitionState<PeopleUserInputAnimationState>
    = MutableTransitionState(PeopleUserInputAnimationState.Valid)

    fun addPerson(){
        people = (people % (MAX_PEOPLE + 1)) + 1
        updateAnimationState()
    }

    private fun updateAnimationState(){
        val newState =
            if (people > MAX_PEOPLE) PeopleUserInputAnimationState.Invalid
            else PeopleUserInputAnimationState.Valid

        if (animationState.currentState != newState) animationState.targetState = newState
    }
}


@Composable
fun PeopleUserInput(
    titleSuffix: String = "",
    onPeopleChanged: (Int) -> Unit,
    peopleState: PeopleUserInputState = remember{PeopleUserInputState()}
){
    Column() {

        val transitionState = remember {
            peopleState.animationState
        }

        val tint = tintPeopleUserInput(transitionState)

        val people = peopleState.people

        BasicUserInput(
            text = if(people == 1) "$people Adult$titleSuffix" else "$people Adults$titleSuffix",
            tint = tint.value,
            onClick = {
                peopleState.addPerson()
                onPeopleChanged(peopleState.people)
            }
        )

        if(transitionState.targetState == PeopleUserInputAnimationState.Invalid){
            Text(
                text = "Error: We don't support more than $MAX_PEOPLE people",
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.secondary)
            )
        }
    }
}

@Composable
fun FromDestination(){
    BasicUserInput(text = "Santiago, Chile")
}

@Composable
fun ToDestinationUserInput(
    onToDestinationChanged: (String)->Unit
){
    val editableUserInputState = rememberEditableUserInputState(hint = "Choose Destination")
    BasicEditableUserInput(
        state = editableUserInputState,
        caption= "To",)

    val currentOnDestinationChanged by rememberUpdatedState(newValue = onToDestinationChanged)
    LaunchedEffect(onToDestinationChanged){
        snapshotFlow { editableUserInputState.text }
            .filter { !editableUserInputState.isHint }
            .collect{
                currentOnDestinationChanged(editableUserInputState.text)
            }
    }
}

@Composable
fun DatesUserInput(){
    BasicUserInput(text = "", caption = "Select Dates")
}

@Composable
private fun tintPeopleUserInput(
    transitionState: MutableTransitionState<PeopleUserInputAnimationState>
): State<Color> {
    val validColor = MaterialTheme.colors.onSurface
    val invalidColor = MaterialTheme.colors.secondary

    val transition = updateTransition(transitionState, label="")

    return transition.animateColor(
        transitionSpec = { tween(durationMillis = 300)}, label = ""
    ) {
        if(it == PeopleUserInputAnimationState.Valid) validColor else invalidColor
    }
}
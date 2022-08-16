package com.rrat.advancedstateandsideeffets.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import com.rrat.advancedstateandsideeffets.details.screens.DetailsScreen
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme
import dagger.hilt.android.AndroidEntryPoint


internal const val KEY_ARG_DETAILS_CITY_NAME = "KEY_ARG_DETAILS_CITY_NAME"

fun launchDetailsActivity(context: Context, item: ExploreModel){
    context.startActivity(createDetailsActivityIntent(context, item))
}

@VisibleForTesting
fun createDetailsActivityIntent(context: Context, item: ExploreModel): Intent{
    val intent = Intent(context, DetailsActivity::class.java)
    intent.putExtra(KEY_ARG_DETAILS_CITY_NAME, item.city.name)
    return intent
}

data class DetailsUiState(
    val cityDetails: ExploreModel? = null,
    val isLoading: Boolean = false,
    val throwError: Boolean = false
)

@AndroidEntryPoint
class DetailsActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent{
            AdvancedStateAndSideEffetsTheme() {
                Surface {
                    DetailsScreen(
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding()
                        ,
                        onErrorLoading = {finish()}
                    )
                }
            }
        }
    }
}
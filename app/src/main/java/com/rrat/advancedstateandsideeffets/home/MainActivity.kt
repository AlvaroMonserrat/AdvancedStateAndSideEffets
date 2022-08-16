package com.rrat.advancedstateandsideeffets.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.rrat.advancedstateandsideeffets.details.launchDetailsActivity
import com.rrat.advancedstateandsideeffets.home.screens.MainScreen
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AdvancedStateAndSideEffetsTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(
                    onExploreItemClicked = {
                        launchDetailsActivity(context=this, item=it)
                    }
                )
            }
        }
    }
}


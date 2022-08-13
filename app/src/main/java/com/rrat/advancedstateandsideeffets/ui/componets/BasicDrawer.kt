package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.R
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme


private val screens = listOf("Find Raffle","Create Raffle", "My Raffles", "My Account")

@Composable
fun BasicDrawer(
    modifier: Modifier = Modifier
){
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top=48.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_rb),
            contentDescription = stringResource(id = R.string.logo_rb)
        )
        
        for(screen in screens){
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen,
                style = MaterialTheme
                    .typography
                    .h5
                    .copy(fontWeight = FontWeight.Bold))
        }
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 600)
@Composable
fun BasicDrawerPreview(){
    AdvancedStateAndSideEffetsTheme() {
        BasicDrawer()
    }
}
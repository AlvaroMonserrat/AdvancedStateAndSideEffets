package com.rrat.advancedstateandsideeffets.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrat.advancedstateandsideeffets.R
import com.rrat.advancedstateandsideeffets.home.RaffleScreen
import com.rrat.advancedstateandsideeffets.ui.theme.AdvancedStateAndSideEffetsTheme


@Composable
fun BasicTabBar(
    modifier: Modifier = Modifier,
    openDrawer: ()->Unit,
    children: @Composable (Modifier)->Unit
){
    Row(
        modifier=modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        
        Row(Modifier.padding(top = 8.dp)) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable(onClick = openDrawer),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = stringResource(id = R.string.menu)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_logo_rb),
                contentDescription = null
            )
        }
        children(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically))
    }
}

@Preview(showBackground = true, widthDp = 420, heightDp = 600)
@Composable
fun BasicTabBarPreview(){
    AdvancedStateAndSideEffetsTheme() {
        BasicTabBar(openDrawer = {}){}
    }
}
package com.rrat.advancedstateandsideeffets.details.screens

import android.os.Bundle
import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import com.rrat.advancedstateandsideeffets.R
import com.rrat.advancedstateandsideeffets.data.ExploreModel
import kotlinx.coroutines.launch
import java.lang.IllegalStateException


@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    exploreModel: ExploreModel
){
    Column(modifier=modifier, verticalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier=Modifier.align(Alignment.CenterHorizontally),
            text = exploreModel.city.nameToDisplay,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
        Text(
            modifier=Modifier.align(Alignment.CenterHorizontally),
            text = exploreModel.description,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        CityMapView(exploreModel.city.latitude, exploreModel.city.longitude)
    }
}

@Composable
private fun CityMapView(
    latitude: String,
    longitude: String
){
    val mapView = rememberMapViewWithLifecycle()
    MapViewContainer(mapView, latitude = latitude, longitude = longitude)
}

@Composable
private fun MapViewContainer(
    map: MapView,
    latitude: String,
    longitude: String
){
    val cameraPosition = remember(latitude, longitude) {
        LatLng(latitude.toDouble(), longitude.toDouble())
    }

    LaunchedEffect(map) {
        val googleMap = map.awaitMap()
        googleMap.addMarker { position(cameraPosition) }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(cameraPosition))
    }

    var zoom by rememberSaveable(map) { mutableStateOf(InitialZoom) }
    ZoomControls(zoom) {
        zoom = it.coerceIn(MinZoom, MaxZoom)
    }

    val coroutineScope = rememberCoroutineScope()

    AndroidView({map}){
        mapView->
        val mapZoom = zoom
        coroutineScope.launch {
            val googleMap = mapView.awaitMap()
            googleMap.setZoom(mapZoom)

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(cameraPosition))
        }
    }
}

@Composable
private fun ZoomControls(
    zoom: Float,
    onZoomChanged: (Float)->Unit
){
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center){
        ZoomButton(text = "-") {
            onZoomChanged(zoom*0.8f)
        }
        ZoomButton(text = "+") {
            onZoomChanged(zoom*1.2f)
        }
    }
}

@Composable
private fun ZoomButton(text: String, onClick: ()->Unit){
    Button(
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.onPrimary,
            contentColor = MaterialTheme.colors.primary
        ),
        onClick = onClick
    ) {
        Text(text = text, style = MaterialTheme.typography.h5)
    }
}

@Composable
fun rememberMapViewWithLifecycle(): MapView{

    val context = LocalContext.current

    val mapView = remember{
        MapView(context).apply {
            id = R.id.map
            onCreate(Bundle())
        }
    }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(key1 = lifecycle, key2 = mapView){
        val lifecycleObserver = getMapLifecycleObserver(mapView)
        lifecycle.addObserver(lifecycleObserver)
        onDispose{
            lifecycle.removeObserver(lifecycleObserver)
        }
    }

    return mapView
}

fun GoogleMap.setZoom(
    @FloatRange(from = MinZoom.toDouble(), to = MaxZoom.toDouble()) zoom: Float
) {
    resetMinMaxZoomPreference()
    setMinZoomPreference(zoom)
    setMaxZoomPreference(zoom)
}

private fun getMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
        LifecycleEventObserver{_, event ->
        when(event){
            Lifecycle.Event.ON_CREATE->mapView.onCreate(Bundle())
            Lifecycle.Event.ON_START->mapView.onStart()
            Lifecycle.Event.ON_RESUME->mapView.onResume()
            Lifecycle.Event.ON_PAUSE->mapView.onPause()
            Lifecycle.Event.ON_STOP->mapView.onStop()
            Lifecycle.Event.ON_DESTROY->mapView.onDestroy()
            else->throw IllegalStateException()
        }
    }

private const val InitialZoom = 5f
const val MinZoom = 2f
const val MaxZoom = 20f
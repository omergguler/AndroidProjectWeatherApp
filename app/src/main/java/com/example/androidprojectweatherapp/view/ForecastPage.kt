package com.example.androidprojectweatherapp.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidprojectweatherapp.constant.Const
import com.example.androidprojectweatherapp.model.forecast.ForecastMenu
import com.example.androidprojectweatherapp.model.forecast.ForecastResult

@Composable
fun forecastsPage(weatherResponse: ForecastResult) {
    Log.i("Fore",weatherResponse.toString())
    val gradient = Brush.linearGradient(
        colors = listOf(Color(Const.colorBg1), Color(Const.colorBg2)),
        start = Offset(1000f, -1000f),
        end = Offset(1000f, 1000f)
    )
    val forecastList = weatherResponse.list!!.map {
        ForecastMenu( it.weather!![0].main.toString(),
            it.main!!.temp.toString(),
            it.wind!!.speed.toString(),
            it.main!!.humidity.toString(),
            it.dtTxt!!.split(" ")[1],
            it.dtTxt!!.split(" ")[0])
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ){
        LazyColumn {
            item {
                // Column headers
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Text(text = "Type", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(90.dp))
                    Text(text = "Temperature", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.width(90.dp))
                    Text(text = "Time", style = MaterialTheme.typography.bodyMedium)
                }
            }

            items(forecastList) { forecast ->
                ForecastItem(forecast)
            }
        }
    }
}


@Composable
fun ForecastItem(forecast: ForecastMenu) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = forecast.weather, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.width(90.dp))
        Text(text = forecast.temp, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.width(90.dp))
        Text(text = forecast.hour, style = MaterialTheme.typography.bodyMedium)

    }
}
package com.example.androidprojectweatherapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.androidprojectweatherapp.constant.Const.Companion.LOADING
import com.example.androidprojectweatherapp.constant.Const.Companion.NA
import com.example.androidprojectweatherapp.model.weather.WeatherResult
import com.example.androidprojectweatherapp.utils.Utils.Companion.buildIcon
import com.example.androidprojectweatherapp.utils.Utils.Companion.timestampToHumanDate

@Composable
fun WeatherSection(weatherResponse: WeatherResult, navController: NavHostController) {

    var title = ""
    if (!weatherResponse.name.isNullOrEmpty()){
        weatherResponse?.name?.let {
            title = it
        }
    }
    else {
        weatherResponse.coord?.let {
            title = "${it.lat}/${it.lon}"
        }
    }

    var subTitle = ""
    var dateVal = (weatherResponse.dt ?: 0)
    subTitle = if(dateVal == 0) LOADING
    else timestampToHumanDate(dateVal.toLong(), "dd-MM-yyyy")

    var icon = ""
    var description = ""

    weatherResponse.weather.let {
        if (it!!.size > 0){
            description = if (it[0].icon == null) LOADING else it[0].description!!
            icon = if (it[0].icon == null) LOADING else it[0].icon!!
        }
    }

    var temp = ""
    weatherResponse.main?.let {
        temp = "${it.temp}C"
    }


    var wind = ""
    weatherResponse.wind.let {
        wind = if (it == null) LOADING else "${it.speed}"
    }

    var clouds = ""
    weatherResponse.clouds.let {
        clouds = if (it == null) LOADING else "${it.all}"
    }

    var snow = ""
    weatherResponse.snow.let {
        snow = if (it == null) NA else "${it.d1h}"
    }

    WeatherTitleSection(text = title, subText = subTitle, fontSize = 30.sp)
    WeatherImage(icon = icon)
    WeatherTitleSection(text = temp, subText = description, fontSize = 60.sp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherInfo(text = wind)
        WeatherInfo(text = clouds)
        WeatherInfo(text = snow)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { navController.navigate("forecastScreen") },
            // Customize button appearance as needed
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Forecasts")
        }
    }
}

@Composable
fun WeatherInfo(text: String) {
    Column {
        Text(text = text, fontSize = 24.sp, color = Color.White)
    }
}

@Composable
fun WeatherImage(icon: String) {
    AsyncImage(model = buildIcon(icon), contentDescription = icon,
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun WeatherTitleSection(text: String, subText: String, fontSize: TextUnit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = fontSize, color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = subText, fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Normal)
    }
}

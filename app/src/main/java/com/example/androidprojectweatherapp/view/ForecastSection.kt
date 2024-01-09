//package com.example.androidprojectweatherapp.view
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.example.androidprojectweatherapp.constant.Const.Companion.NA
//import com.example.androidprojectweatherapp.constant.Const.Companion.cardColor
//import com.example.androidprojectweatherapp.model.forecast.ForecastResult
//
//@Composable
//fun ForecastSection(forecastResponse: ForecastResult) {
//    return Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        forecastResponse.list.let { listForecast ->
//            if (listForecast!!.size > 0){
//                LazyRow(
//                    modifier = Modifier.fillMaxSize()
//                ){
//                    items(listForecast!!){ currentItem ->
//                        currentItem.let { item ->
//                            var temp = ""
//                            var icon = ""
//                            var time = ""
//
//                            item.main.let {main ->
//                                temp = if (main == null) NA else "${main.temp}C"
//                            }
//
//                            item.weather.let { weather ->
//                                icon = if (weather == null) NA else buildIcon(
//                                    weather[0].icon!!,
//                                    isBigSize = false
//                                )
//                            }
//
//                            item.dt.let {dateTime ->
//                                time = if (dateTime == null) NA
//                                else timestampToHumanDate(dateTime.toLong, "HH.mm")
//                            }
//
//                            ForecastTile(temp = temp, image = icon, time = time)
//
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ForecastTile(temp: String, image: Any, time: String) {
//    Card(
//        modifier = Modifier
//            .padding(20.dp)
//            .fillMaxWidth(),
//        colors = CardDefaults.cardColors(
//            containerColor = Color(cardColor).copy(alpha = 0.7f),
//            contentColor = Color.White
//        )
//    ) {
//        Column {
//
//        }
//
//    }
//}

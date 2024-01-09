package com.example.androidprojectweatherapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojectweatherapp.model.MyLatLng
import com.example.androidprojectweatherapp.model.forecast.ForecastResult
import com.example.androidprojectweatherapp.model.weather.WeatherResult
import com.example.androidprojectweatherapp.network.RetrofitClient
import kotlinx.coroutines.launch


enum class STATE {
    LOADING,
    SUCCESS,
    FAILED
}
class MainViewModel: ViewModel() {
    //control state of viewmodel
    var state by mutableStateOf(STATE.LOADING)

    //hold value from api for weather info
    var weatherResponse : WeatherResult by mutableStateOf(WeatherResult())

    //hold value from api for forecast info
    var forecastResponse: ForecastResult by mutableStateOf(ForecastResult())

    var errorMessage: String by mutableStateOf("")

    fun getWeatherByLocation(latLng: MyLatLng){
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try{
                val apiResponse = apiService.getWeather(latLng.lat, latLng.lng)
                weatherResponse = apiResponse //update state
                state = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message!!.toString()
                state = STATE.FAILED
            }
        }















    }

    fun getForecastByLocation(latLng: MyLatLng){
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try{
                val apiResponse = apiService.getForecast(latLng.lat, latLng.lng)
                forecastResponse = apiResponse //update state
                state = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message!!.toString()
                state = STATE.FAILED
            }
        }















    }
}
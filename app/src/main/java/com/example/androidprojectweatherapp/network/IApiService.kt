package com.example.androidprojectweatherapp.network

import com.example.androidprojectweatherapp.constant.Const.Companion.openWeatherMapApiKey
import com.example.androidprojectweatherapp.model.forecast.ForecastResult
import com.example.androidprojectweatherapp.model.weather.WeatherResult
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat: Double = 0.0,
        @Query("lon") lng: Double = 0.0,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = openWeatherMapApiKey,
    ): WeatherResult

    @GET("forecast")
    suspend fun getForecast(
        @Query("lat") lat: Double = 0.0,
        @Query("lon") lng: Double = 0.0,
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = openWeatherMapApiKey,
    ): ForecastResult
}
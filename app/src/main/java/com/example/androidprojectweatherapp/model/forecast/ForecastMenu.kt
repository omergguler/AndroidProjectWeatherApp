package com.example.androidprojectweatherapp.model.forecast

data class ForecastMenu(
    val weather: String,
    val temp: String,
    val wind: String?,
    val humidity: String?,
    val hour: String,
    val date: String?
)
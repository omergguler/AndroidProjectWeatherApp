package com.example.androidprojectweatherapp.constant

class Const {
    companion object {
        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        const val openWeatherMapApiKey = "b52739ace2fe36da899202ff0eee16fb"

        const val colorBg1 = 0xff08203e
        const val colorBg2 = 0xff557c93

        const val LOADING = "Loading..."
        const val NA = "N/A"
    }
}
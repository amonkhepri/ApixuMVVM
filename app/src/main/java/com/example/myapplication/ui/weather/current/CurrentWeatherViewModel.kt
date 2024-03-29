package com.example.myapplication.ui.weather.current


import androidx.lifecycle.ViewModel;
import com.example.myapplication.data.provider.UnitProvider
import com.example.myapplication.data.repository.ForecastRepository
import com.example.myapplication.internal.UnitSystem
import com.example.myapplication.internal.lazyDeferred


class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}
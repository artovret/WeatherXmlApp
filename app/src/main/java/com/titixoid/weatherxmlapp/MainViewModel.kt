package com.titixoid.weatherxmlapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.titixoid.weatherxmlapp.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}
package com.example.firstprojectIchaiChtitski

import android.content.Context

 class LocalWeather(temperature:Float, location:String): Weather(temperature
 ,location) {
    //constructor(weather: Weather): super(weather)
     override fun isHot():Boolean{
         return this.temperature > 32
     }

}
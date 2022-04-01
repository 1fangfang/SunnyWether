package com.sunnywether.android.logic.model

import com.google.gson.annotations.SerializedName

/*
定义数据模型
 */
data class PlaceResponse(val status: String, val places: List<Place>) // 返回的地址数据：状态，城市列表

data class Place(val name: String, val location: Location,
                 @SerializedName("formatted_address") val address: String) // 城市名字，坐标,地址

data class Location(val lng: String, val lat:String) // 横纵坐标
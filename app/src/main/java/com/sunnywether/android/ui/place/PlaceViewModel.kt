package com.sunnywether.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnywether.android.logic.Repository
import com.sunnywether.android.logic.model.Place

/*
通过searchPlaces()改变searchLiveData的从而触发switchMap。
使之调用Repository.searchPlaces(query)并返回一个可观察的LiveData： placeLiveData
 */

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()


    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}
package com.sunnywether.android.logic

import androidx.lifecycle.liveData
import com.sunnywether.android.logic.model.Place
import com.sunnywether.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/*
仓库层
城市数据请求没有缓存必要
因此只有网络请求
返回一个LiveData对象。
 */

object Repository {
    fun searchPlaces(query: String) =
        // 自动构建并返回一个LiveData对象
        // Dispatchers.IO 使得代码块中所有代码都运行在子线程中。
        liveData(Dispatchers.IO){
            val result = try {
                val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
                if (placeResponse.status == "ok"){
                    val places = placeResponse.places
                    Result.success(places)
                } else {
                    Result.failure(RuntimeException("response status is ${placeResponse.status}"))
                }
            } catch (e: Exception){
                Result.failure<List<Place>>(e)
            }
            // 发射数据，类似于setValue()。因为此时没有LiveData对象所以。
            emit(result)
        }
}
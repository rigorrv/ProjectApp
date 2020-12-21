package net.android.projectapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import net.android.projectapp.database.PostDao
import net.android.projectapp.model.JsonData
import net.android.projectapp.network.Api
import net.android.projectapp.utility.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel(private val api: Api, private val postDao: PostDao) : ViewModel() {


    var jsonLivedata = MutableLiveData<JsonData>()

    init {
        if (Connection.isConnected())
            getJson()
        else
            loadSql()
    }

    private fun getJson() {
        api.getJson().enqueue(object : Callback<JsonData> {
            override fun onResponse(call: Call<JsonData>, response: Response<JsonData>) {
                jsonLivedata.value = response.body()
                insertSql(response.body()!!)
            }

            override fun onFailure(call: Call<JsonData>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t}")
            }
        })
    }

    private fun insertSql(jsonData: JsonData) {
        viewModelScope.async(Dispatchers.IO + NonCancellable) {
            postDao.insertJson(jsonData)
        }
    }

    private fun loadSql() {
        viewModelScope.async(Dispatchers.IO + NonCancellable) {
            jsonLivedata.postValue(postDao.allJson())
        }
    }
}
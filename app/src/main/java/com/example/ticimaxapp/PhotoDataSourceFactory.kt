package com.example.ticimaxapp

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.ticimaxapp.models.Result

class PhotoDataSourceFactory : DataSource.Factory<Int,Result>() {
    private val photoLiveDataSource = MutableLiveData<PhotoDataSource>()

    override fun create(): DataSource<Int, Result> {

        val dataSource = PhotoDataSource()
        photoLiveDataSource.postValue(dataSource)
        return dataSource

    }
}
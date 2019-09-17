package com.example.ticimaxapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.ticimaxapp.PhotoDataSourceFactory
import com.example.ticimaxapp.services.PER_PAGE

class MainViewModel : ViewModel() {

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(PER_PAGE)
        .build()
    private val photoDataSourceFactory = PhotoDataSourceFactory()
    val livePagedList = LivePagedListBuilder(photoDataSourceFactory,config).build()

}
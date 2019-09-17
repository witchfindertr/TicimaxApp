package com.example.ticimaxapp

import androidx.paging.PageKeyedDataSource
import com.example.ticimaxapp.models.PhotoResponse
import com.example.ticimaxapp.models.Result
import com.example.ticimaxapp.services.FIRST_PAGE
import com.example.ticimaxapp.services.FORMAT
import com.example.ticimaxapp.services.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class PhotoDataSource : PageKeyedDataSource<Int,Result>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Result>) {
        RetrofitClient.getClient()
            .getPhotos(FORMAT, BuildConfig.AccessToken, FIRST_PAGE)
            .enqueue(object : Callback<PhotoResponse>{
                override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
                    response.body().let {
                        callback.onResult(it!!.result, null, FIRST_PAGE+1)
                    }
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        RetrofitClient.getClient()
            .getPhotos(FORMAT, BuildConfig.AccessToken, params.key)
            .enqueue(object : Callback<PhotoResponse>{
                override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
                    response.body().let {
                        if(it!!.meta.currentPage < it.meta.pageCount){
                            callback.onResult(it.result,params.key+1)
                        }
                        else{
                            callback.onResult(it.result,null)
                        }
                    }
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Result>) {
        TODO("recyclerview already handling it. Not necessary")
    }
}
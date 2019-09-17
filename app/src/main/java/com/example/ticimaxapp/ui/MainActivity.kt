package com.example.ticimaxapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticimaxapp.R
import com.example.ticimaxapp.adapters.PhotoListAdapter
import com.example.ticimaxapp.models.Result
import com.example.ticimaxapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : PhotoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_main.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recycler_main.setHasFixedSize(true)
        adapter = PhotoListAdapter()
        recycler_main.adapter = adapter

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.livePagedList.observe(this,photoListObserver)
    }

    private val photoListObserver = Observer<PagedList<Result>>{
        adapter.submitList(it)
    }
}

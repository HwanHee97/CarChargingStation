package com.example.carchargingstation.fragments.search

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carchargingstation.MainViewModel
import com.example.carchargingstation.R
import com.example.carchargingstation.databinding.FragmentSearchBinding
import com.example.carchargingstation.fragments.search.adapter.RecyclerViewAdapter
import com.example.carchargingstation.rpdatamodel.ChargingStationState
import com.example.carchargingstation.utils.Constants
import com.example.carchargingstation.utils.Constants.TAG


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private val searchRecyclerViewAdapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //Log.d(TAG, "SEATCH" + this.id.toString())
        binding = FragmentSearchBinding.inflate(layoutInflater)
        setButtonListener()
        setRecyclerView()
        setObserve()
        return binding.root
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            addItemDecoration(RecyclerViewDecoration(10, Color.LTGRAY))
            adapter = searchRecyclerViewAdapter
        }
    }

    private fun setObserve() {//
        Log.d(Constants.TAG, "SearchFragment - setObserve() called")
        viewModel.stationData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Log.d(TAG, "SearchFragment - setObserve() called  뷰모델의 데이터 변경됨 :  ${it.body.items.item[0]}")
            searchRecyclerViewAdapter.notifyStationDataChange(it)
        })
    }

    private fun setButtonListener() {
        binding.apply {
            searchButton.setOnClickListener(View.OnClickListener {
                viewModel.getSearchData(searchEdittext.text.toString())
            })
        }
    }

}
package com.example.carchargingstation.fragments.search.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.carchargingstation.databinding.ItemStationBinding
import com.example.carchargingstation.rpdatamodel.Item

class ChargingStationStateViewHolder(val binding:ItemStationBinding):RecyclerView.ViewHolder(binding.root) {

    fun bindWithView(item:Item){
        with(binding){
            station=item
        }

    }

}
package com.example.carchargingstation.fragments.search.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.carchargingstation.R
import com.example.carchargingstation.databinding.ItemStationBinding
import com.example.carchargingstation.fragments.search.viewholder.ChargingStationStateViewHolder
import com.example.carchargingstation.rpdatamodel.ChargingStationState
import com.example.carchargingstation.utils.Constants

class RecyclerViewAdapter(val ChargingStationStatedata:ChargingStationState):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(Constants.TAG,"RecyclerViewAdapter - onCreateViewHolder()")

        val binding = ItemStationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChargingStationStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(Constants.TAG,"RecyclerViewAdapter - onBindViewHolder() position : ${position}")

        when(holder){
            is ChargingStationStateViewHolder ->{
                holder.bindWithView(this.ChargingStationStatedata.body.items.item[position])
            }

        }
    }

    override fun getItemCount(): Int {
        Log.d(Constants.TAG,"RecyclerViewAdapter - ChargingStationStatedata.body.items.item.size :  ${ChargingStationStatedata.body.items.item.size}")

        return ChargingStationStatedata.body.items.item.size
    }


}
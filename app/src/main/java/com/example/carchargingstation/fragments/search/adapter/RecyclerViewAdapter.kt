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

class RecyclerViewAdapter():RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var chargingStationStateData:ChargingStationState?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(Constants.TAG,"RecyclerViewAdapter - onCreateViewHolder()")

        val binding = ItemStationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChargingStationStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(Constants.TAG,"RecyclerViewAdapter - onBindViewHolder() position : ${position}")
        when(holder){
            is ChargingStationStateViewHolder ->{
                this.chargingStationStateData?.body?.items?.item?.get(position)?.let {
                    holder.bindWithView(it)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        Log.d(Constants.TAG,"RecyclerViewAdapter - ChargingStationStatedata.body.items.item.size :  ${chargingStationStateData?.body?.items?.item?.size}")
        return chargingStationStateData?.body?.items?.item?.size ?: 0
    }
    fun notifyStationDataChange(newData:ChargingStationState){
        chargingStationStateData=newData
        notifyDataSetChanged()
    }

}
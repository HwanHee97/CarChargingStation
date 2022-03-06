package com.example.carchargingstation.fragments.search.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.carchargingstation.R

@BindingAdapter("custom:setStateImage")
fun setStateImage(imageView: ImageView, state: Int) {
    when (state) {
        1 -> imageView.setImageResource(R.drawable.ic_baseline_charging_possible_24)
        2 -> imageView.setImageResource(R.drawable.ic_baseline_charging_in_use_24)
        3, 4, 5 -> imageView.setImageResource(R.drawable.ic_baseline_charging_impossible_24)
    }
}

@BindingAdapter("custom:setChargeType")
fun setChargeType(textView: TextView, type: Int) {
    when (type) {
        1 -> textView.setText(R.string.slow_charge)
        2 -> textView.setText(R.string.fast_charge)
    }
}

@BindingAdapter("custom:setChargePinType")
fun setChargePinType(textView: TextView, type: Int) {
    textView.setText(
        when (type) {
            1 -> R.string.charge_pin_type_1
            2 -> R.string.charge_pin_type_2
            3 -> R.string.charge_pin_type_3
            4 -> R.string.charge_pin_type_4
            5 -> R.string.charge_pin_type_5
            6 -> R.string.charge_pin_type_6
            7 -> R.string.charge_pin_type_7
            8 -> R.string.charge_pin_type_8
            9 -> R.string.charge_pin_type_9
            10 -> R.string.charge_pin_type_10
            else -> R.string.no_data
        }
    )
}
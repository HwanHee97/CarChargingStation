package com.example.carchargingstation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.carchargingstation.databinding.ActivityMainBinding
import com.example.carchargingstation.utils.Constants.TAG
import com.example.carchargingstation.utils.FragmentType
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setContentView(binding.root)
        //	BottomNavigationView.OnNavigationItemSelectedListener 인터페이스는 deprecated돼서
        //	NavigationBarView.OnItemSelectedListener로 변경
        changeFragment(FragmentType.SEARCH)
        binding.bottomNaviMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search -> {
                    Log.d(TAG,"SearchFragment클릭")
                    changeFragment(FragmentType.SEARCH)
                    true
                }
                R.id.map -> {
                    Log.d(TAG,"MapFragment클릭")
                    changeFragment(FragmentType.MAP)
                    true
                }
                R.id.third -> {
                    Log.d(TAG,"thirdFragment클릭")
                    true
                }
                else -> false
            }
        }
        
    }
    private fun changeFragment(type:FragmentType) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, getFragment(type)).commit()
    }
    private fun getFragment(type:FragmentType):Fragment{
        return when(type){
            FragmentType.SEARCH->SearchFragment()
            FragmentType.MAP->MapFragment()
        }
    }

    fun setBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}
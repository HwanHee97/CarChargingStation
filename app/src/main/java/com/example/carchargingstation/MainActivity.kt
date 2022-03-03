package com.example.carchargingstation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carchargingstation.databinding.ActivityMainBinding
import com.example.carchargingstation.fragments.map.MapFragment
import com.example.carchargingstation.fragments.search.SearchFragment
import com.example.carchargingstation.utils.Constants.TAG
import com.example.carchargingstation.utils.FragmentType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
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
                    mainViewModel.getHomeData()
                    true
                }
                R.id.third -> {
                    Log.d(TAG,"thirdFragment클릭")
                    true
                }
                else -> false
            }
        }

        setObserve()

    }
    private fun changeFragment(type:FragmentType) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, getFragment(type)).commit()
    }
    private fun getFragment(type:FragmentType):Fragment{
        return when(type){
            FragmentType.SEARCH-> SearchFragment()
            FragmentType.MAP-> MapFragment()
        }
    }

    private fun setBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private fun setObserve() {//
        //Log.d(Constants.TAG,"!!MainActivity - setObserve() called")
        mainViewModel.stationData.observe(this, androidx.lifecycle.Observer {
            Log.d(TAG,"MainActivity - setObserve() called  뷰모델의 데이터 변경됨 :  ${it.body.items.item[0]}")

        })
    }

}


package com.example.carchargingstation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.carchargingstation.databinding.ActivityMainBinding
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
        binding.bottomNaviMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.search -> {
                    Log.d("로그","SearchFragment클릭")
                    changeFragment(SearchFragment())
                    true
                }
                R.id.map -> {
                    Log.d("로그","MapFragment클릭")
                    changeFragment(MapFragment())
                    true
                }
                R.id.third -> {
                    Log.d("로그","thirdFragment클릭")
                    true
                }
                else -> false
            }
        }
        
    }
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, fragment).commit()
    }
    fun setBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}
package com.dungtran.androidd20l11

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val tabHomeFragment = TabHomeFragment()
        val tabPlayFragment = TabPlayFragment()
        val tabSettingFragment = TabSettingFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragmentContent, tabHomeFragment)
            commit()
        }
        val bnTab = findViewById<BottomNavigationView>(R.id.bnTab)
        bnTab.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    replaceFragmentBottomNavigation(tabHomeFragment)
                    true
                }
                R.id.playFragment -> {
                    replaceFragmentBottomNavigation(tabPlayFragment)
                    true
                }
                else -> {
                    replaceFragmentBottomNavigation(tabSettingFragment)
                    true
                }
            }
        }
    }
    fun replaceFragmentBottomNavigation(tabFragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragmentContent, tabFragment)
            addToBackStack(null)
            commit()
        }
    }
}
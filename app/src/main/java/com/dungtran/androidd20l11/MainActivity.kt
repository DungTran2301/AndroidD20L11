package com.dungtran.androidd20l11

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
        val BottomNavigationView = findViewById<BottomNavigationView>(R.id.bnTab)
        BottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    binding.tvtoolbar.setText("   Home")
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabHomeFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.playFragment -> {
                    binding.tvtoolbar.setText("   Play")
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabPlayFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.settingFragment -> {
                    binding.tvtoolbar.setText("   Setting")
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabSettingFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                else -> false
            }
        }
    }
}
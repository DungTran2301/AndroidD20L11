package com.dungtran.androidd20l11

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabHomeFragment = TabHomeFragment()
        val tabPlayFragment = TabPlayFragment()
        val tabSettingFragment = TabSettingFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragmentContent, tabHomeFragment)
            commit()
        }
        val tvtoolbar = findViewById<TextView>(R.id.tvtoolbar)
        val BottomNavigationView = findViewById<BottomNavigationView>(R.id.bnTab)
        BottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    tvtoolbar.setText("   Home")
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabHomeFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.playFragment -> {
                    tvtoolbar.setText("   Play")
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabPlayFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.settingFragment -> {
                    tvtoolbar.setText("   Setting")
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
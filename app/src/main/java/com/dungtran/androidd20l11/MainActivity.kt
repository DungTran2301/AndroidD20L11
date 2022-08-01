package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabHomeFragment = TabHomeFragment()
        val tabPlayFragment = TabPlayFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flTabContent, tabHomeFragment)
            commit()
        }

        val tiHome = findViewById<TabItem>(R.id.tiHome)
        val tiPlay = findViewById<TabItem>(R.id.tiPlay)

        tiHome.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flTabContent, tabHomeFragment)
                addToBackStack(null)
                commit()
            }
        }
        tiPlay.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flTabContent, tabPlayFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}
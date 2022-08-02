package com.dungtran.androidd20l11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dungtran.androidd20l11.adapter.PlayAdapter
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            vpTabBarFavorite.adapter = PlayAdapter(supportFragmentManager, lifecycle)
            TabLayoutMediator(tabLayout, vpTabBarFavorite) { tab, position ->
                when (position) {
                    0 -> tab.text = "Favorite"
                    1 -> tab.text = "Your Music"
                }
            }.attach()
        }


        setContentView(binding.root)
    }
}
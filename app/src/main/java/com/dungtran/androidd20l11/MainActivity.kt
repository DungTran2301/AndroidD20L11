package com.dungtran.androidd20l11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dungtran.androidd20l11.adapter.PlayAdapter
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHost
        val navController = navHost.navController

        binding.bottomNav.setupWithNavController(navController)

        val bottomBarConfig = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.playFragment, R.id.settingFragment
            )
        )

        setupActionBarWithNavController(navController, bottomBarConfig)



    }
}
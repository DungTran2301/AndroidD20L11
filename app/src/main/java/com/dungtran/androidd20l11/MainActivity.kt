package com.dungtran.androidd20l11

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import com.dungtran.androidd20l11.mainfragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var buttomNavigationBarView: NavigationBarView
    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        val host = NavHostFragment.create(R.navigation.nav_graph)
//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, host)
//            .setPrimaryNavigationFragment(host).commit()

        buttomNavigationBarView = binding.bottomNavigation
        buttomNavigationBarView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    NavController
                    this.findNavController(R.id.fragmentContainer).navigate(R.id.homeFragment)
                    true
                }
                R.id.navigation_play -> {
                    this.findNavController(R.id.fragmentContainer).navigate(R.id.playFragment)
                    true
                }
                R.id.navigation_setting -> {
                    this.findNavController(R.id.fragmentContainer).navigate(R.id.settingFragment)
                    true
                }
                else -> false
            }
        }

        setContentView(binding.root)
      // hideBottomNavi()
    }

    fun hideBottomNavi() {
        val navController = this.findNavController(R.id.fragmentContainer)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(this, navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment) {
                buttomNavigationBarView.visibility = View.VISIBLE
            } else {
                buttomNavigationBarView.visibility = View.GONE
            }
        }
    }
}
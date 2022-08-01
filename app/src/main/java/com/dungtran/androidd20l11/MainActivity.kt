package com.dungtran.androidd20l11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dungtran.androidd20l11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        stuff()
        bottomNavigationSetup()
        setContentView(binding.root)
    }



    private fun stuff() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    private fun bottomNavigationSetup() {

        navController =
            binding.fragmentContainerView.getFragment<NavHostFragment>().navController

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.homeFragment, R.id.playFragment, R.id.settingFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        hideBottomNavi()

        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun hideBottomNavi() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.editProfileFragment) {
                binding.bottomNavigationView.visibility = View.GONE
            } else {
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

}
package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.dungtran.androidd20l11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var hostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavController()
        setUpBottomNavigation()
        setUpTitle()

    }

    private fun setUpTitle() {
        appBarConfiguration = AppBarConfiguration(navController.graph )
        binding.toolBar.setupWithNavController(navController,appBarConfiguration)

    }

    private fun setUpBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun setUpNavController() {
        hostFragment = supportFragmentManager.findFragmentById(R.id.frameContainer) as NavHostFragment
        navController = hostFragment.navController
    }


}

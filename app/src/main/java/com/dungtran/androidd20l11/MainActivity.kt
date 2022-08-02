package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var hostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavController()
        setUpBottomNavigation()
        setUpTitle()

    }

    private fun setUpTitle() {
        toolbar = findViewById<View>(R.id.toolBar) as Toolbar
        setSupportActionBar(toolbar)

    }

    private fun setUpBottomNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun setUpNavController() {
        hostFragment = supportFragmentManager.findFragmentById(R.id.frameContainer) as NavHostFragment
        navController = hostFragment.navController
    }


}

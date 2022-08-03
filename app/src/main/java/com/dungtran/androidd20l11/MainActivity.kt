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

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var user = User("Cao Duy Dũng", "0349522135", "caoduydung101@gmail.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigationBar()
    }

    private fun setNavigationBar() {
        navController = binding.container.getFragment<NavHostFragment>().navController
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.playFragment,
                R.id.yourProfileFragment,
                R.id.editProfileFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        hideBottomNavi()
        binding.bottomNav.setupWithNavController(navController)
    }

    private fun hideBottomNavi() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.editProfileFragment) {
                binding.bottomNav.visibility = View.GONE
            } else {
                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

    fun setUser(nUser: User) {
        user = nUser
    }

    fun getUser(): User = user
}
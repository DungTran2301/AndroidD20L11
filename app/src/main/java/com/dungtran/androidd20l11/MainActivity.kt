package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import com.dungtran.androidd20l11.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var _user = User("VanSu", "123456", "vansu@email.com")
    val user get() = _user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNav()
        setUpAppBar()
    }

    private fun setUpBottomNav() {
        navController =
            binding.navHostFragmentContainer.getFragment<NavHostFragment>().navController
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.editUserFragment) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }

    private fun setUpAppBar() {
        setupActionBarWithNavController(
            navController,
            AppBarConfiguration(
                setOf(
                    R.id.homeFragment,
                    R.id.playFragment,
                    R.id.settingFragment,
                    R.id.editUserFragment
                )
            )
        )
    }

    fun updateUser(newUser: User) {
        _user = newUser
    }

}
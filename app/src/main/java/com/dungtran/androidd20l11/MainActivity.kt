package com.dungtran.androidd20l11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dungtran.androidd20l11.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var  navController: NavController
    //private lateinit var hostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var user = User("Vũ Nguyễn Cường","0967232097","abcxyz@gmail.com")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        setNavigationBar()

    }

    private fun setNavigationBar(){
        // hostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        // navController = hostFragment.navController
       navController = binding.container.getFragment<NavHostFragment>().navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.playFragment,
                R.id.settingFragment,
                R.id.editFragment
            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)

        binding.bottomNav.setupWithNavController(navController)
    }

    fun updateUser(newUser:User){
        user = newUser
    }

    fun getUser():User = user

}
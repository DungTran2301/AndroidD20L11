package com.dungtran.androidd20l11

import User
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var user = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabHomeFragment = TabHomeFragment()
        val tabPlayFragment = TabPlayFragment()
        val tabSettingFragment = TabSettingFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragmentContent, tabHomeFragment)
            commit()
        }

        val BottomNavigationView = findViewById<BottomNavigationView>(R.id.bnTab)
        BottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabHomeFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.playFragment -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabPlayFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                R.id.settingFragment -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.flfragmentContent, tabSettingFragment)
                        addToBackStack(null)
                        commit()
                    }
                    true
                }
                else -> false
            }
        }
    }
    fun updateUser(newUser: User) {
        user = newUser
    }
}
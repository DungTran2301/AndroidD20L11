package com.dungtran.androidd20l11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment()


    }

    private fun addFragment() {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.add(
            R.id.frameContainer,
            HomeFragment()
        )
        fragmentTransaction?.commit()


    }
}

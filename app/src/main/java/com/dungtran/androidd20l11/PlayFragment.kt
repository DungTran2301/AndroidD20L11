package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dungtran.androidd20l11.databinding.FragmentPlayBinding
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlayFragment : Fragment() {
    private lateinit var _binding: FragmentPlayBinding
    private lateinit var adapter: Adapter
    private val binding get() = _binding!!
    private var tabTitle = arrayOf("Favourite", "Your music")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        tabLayoutSetup()
        return binding.root
    }


    private fun tabLayoutSetup() {
        if (binding.viewPager2.adapter == null)
            binding.viewPager2.adapter = Adapter(
                parentFragmentManager, lifecycle
            )
        TabLayoutMediator(binding.tabLayout, binding.viewPager2)
        { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }


}
package com.dungtran.androidd20l11.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentPlayBinding
import com.dungtran.androidd20l11.mainfragment.musicadapter.PlayPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PlayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPlayBinding.inflate(inflater, container, false)
        binding.tvHome.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_playFragment_to_homeFragment)
        }
        binding.tvSetting.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_playFragment_to_settingFragment)
        }

        val viewPager = binding.pager
        val tabLayout = binding.tabLayout
        val adapter = PlayPagerAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(adapter.getTitle(position))
        }.attach()
        return binding.root
    }
}
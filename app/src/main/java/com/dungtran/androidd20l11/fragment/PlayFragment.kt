package com.dungtran.androidd20l11.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dungtran.androidd20l11.adapter.PlayAdapter
import com.dungtran.androidd20l11.databinding.FragmentPlayBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            vpTabBarFavorite.adapter = PlayAdapter(childFragmentManager, lifecycle)
            TabLayoutMediator(tabLayout, vpTabBarFavorite) { tab, position ->
                when (position) {
                    0 -> tab.text = "Favorite"
                    1 -> tab.text = "Your Music"
                }
            }.attach()
        }
    }
}
package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import com.dungtran.androidd20l11.databinding.ActivityMainBinding.inflate
import com.dungtran.androidd20l11.databinding.PlayFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlayFragment : Fragment() {

    private lateinit var adapter: ViewPagerAdapter
    private var tabTitle = arrayOf("Favorite","Your music")

    private lateinit var binding: PlayFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PlayFragmentBinding.inflate(inflater,container,false)


        return binding.root
    }

    private fun makeTabLayout(){
        if(binding.viewPager2.adapter == null)
            binding.viewPager2.adapter = ViewPagerAdapter(
                childFragmentManager,lifecycle
            )
        TabLayoutMediator(binding.tabLayout,binding.viewPager2)
        { tab,id ->
            tab.text = tabTitle[id]
        }.attach()
    }

}
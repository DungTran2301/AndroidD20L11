package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dungtran.androidd20l11.databinding.FragmentPlayBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlayFragment : Fragment(R.layout.fragment_play) {
    private lateinit var binding: FragmentPlayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linkViewPagerWithAdapter()
    }

    private fun linkViewPagerWithAdapter() {
        binding.viewPager.adapter = PlayFragmentAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Favourite"
                else -> tab.text = "My Music"
            }
        }.attach()
    }

    class PlayFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> FavoriteFragment()
                else -> MyMusicFragment()
            }
        }
    }
}


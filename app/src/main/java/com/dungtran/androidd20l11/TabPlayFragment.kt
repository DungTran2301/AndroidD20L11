package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabPlayFragment : Fragment(R.layout.fragment_tab_play) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = getView()?.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = getView()?.findViewById<ViewPager2>(R.id.viewPager2)
        val adapter = ViewPaperAdapter(childFragmentManager, lifecycle)
        viewPager2?.adapter = adapter
        tabLayout?.let {
            viewPager2?.let { it1 ->
                TabLayoutMediator(it, it1) { tab, position ->
                    when (position) {
                        0 -> {
                            tab.text = "Favourite"
                        }
                        1 -> {
                            tab.text = "Your Music"
                        }
                    }
                }
            }
        }?.attach()
    }
}
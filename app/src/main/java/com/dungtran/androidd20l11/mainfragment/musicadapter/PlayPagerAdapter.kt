package com.dungtran.androidd20l11.mainfragment.musicadapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.mainfragment.musicfragment.PlayFavoriteFragment
import com.dungtran.androidd20l11.mainfragment.musicfragment.PlayYourMusicFragment

class PlayPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PlayFavoriteFragment()
            else -> PlayYourMusicFragment()
        }
    }

    fun getTitle(position: Int): Int {
        return when (position) {
            0 -> R.string.favorite
            else -> R.string.your_music
        }
    }
}
package com.dungtran.androidd20l11.mainfragment.musicfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dungtran.androidd20l11.databinding.FragmentPlayYourMusicBinding

class PlayYourMusicFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPlayYourMusicBinding.inflate(inflater,container,false)
        return binding.root
    }
}
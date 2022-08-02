package com.dungtran.androidd20l11.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dungtran.androidd20l11.databinding.FragmentYourMusicBinding

class YourMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentYourMusicBinding = FragmentYourMusicBinding.inflate(inflater, container, false)
        return binding.root
    }
}
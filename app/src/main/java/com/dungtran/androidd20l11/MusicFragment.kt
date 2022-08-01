package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dungtran.androidd20l11.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater,container,false)

        return binding.root
    }


}
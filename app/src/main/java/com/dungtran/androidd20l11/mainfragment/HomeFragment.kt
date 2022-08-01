package com.dungtran.androidd20l11.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
//        binding.tvPlay.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.action_homeFragment_to_playFragment)
//        }
//        binding.tvSetting.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
//        }
        return binding.root
    }
}
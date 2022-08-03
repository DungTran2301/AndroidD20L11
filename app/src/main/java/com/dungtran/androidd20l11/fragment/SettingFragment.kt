package com.dungtran.androidd20l11.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentPlayBinding
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        findNavController().navigate(R.id.action_settingFragment_to_profileFragment)
        return binding.root
    }
}
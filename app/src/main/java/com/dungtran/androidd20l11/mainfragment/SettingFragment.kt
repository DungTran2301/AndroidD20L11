package com.dungtran.androidd20l11.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSettingBinding.inflate(inflater, container, false)
        binding.tvHome.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
        }
        binding.tvPlay.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_settingFragment_to_playFragment)
        }
        binding.btnEditProfile.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_settingFragment_to_editProfileFragment)
        }

        val arguments = arguments
        if (arguments != null) {
            val name = arguments.getString("name")
            val email = arguments.getString("email")
            val phone = arguments.getString("phone")
            binding.tvYourName.text = name
            binding.tvYourEmail.text = email
            binding.tvYourPhoneNumber.text = phone
        }
        return binding.root
    }
}
package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentSettingBinding.inflate(inflater,container,false)
        setData(User("Jessica","0981234567","jessica098@gmail.com"))
        return binding.root
    }

    private fun setData(user: User) {
        binding.userName.text = user.userName
        binding.phoneNum.text = user.phoneNum
        binding.email.text = user.email
    }


}
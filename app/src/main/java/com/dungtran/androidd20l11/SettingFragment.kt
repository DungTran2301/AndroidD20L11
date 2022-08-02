package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.constants.Keys
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding
import com.dungtran.androidd20l11.model.User

class SettingFragment : Fragment(R.layout.fragment_setting) {
    private lateinit var binding: FragmentSettingBinding
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingBinding.inflate(inflater)
        user = (activity as MainActivity).user

        setUpClickListeners()
        setUpUserDetail()
        setUpResultListeners()

        return binding.root
    }

    private fun setUpResultListeners() {
        setFragmentResultListener(Keys.USER_UPDATED) { _, _ ->
            setUpUserDetail()
        }
    }

    private fun setUpClickListeners() {
        binding.btEditUser.setOnClickListener {
            editButtonClick()
        }
    }

    private fun editButtonClick() {
        findNavController().navigate(
            R.id.action_settingFragment_to_editUserFragment,
            Bundle().apply {
                putSerializable(Keys.USER_INSTANCE, user)
            })
    }

    private fun setUpUserDetail() {
        binding.apply {
            tvUserName.text = user.name
            tvUserTelephone.text = user.telephone
            tvUserEmail.text = user.email
        }
    }
}
package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding


class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfileBinding.inflate(inflater,container,false)
        setData()
        binding.btnSaveProfile.setOnClickListener {
            clickOn()
        }
        return binding.root
    }

    private fun setData() {
        val user = arguments?.getSerializable("data_user") as User
        binding.userName.setText(user.userName)
        binding.phoneNum.setText(user.phoneNum)
        binding.email.setText(user.email)
    }

    private fun clickOn() {
        val bundle = Bundle()
        bundle.putSerializable(
            "user",
            User(
                binding.userName.text.toString(),
                binding.phoneNum.text.toString(),
                binding.email.text.toString()
            )
        )
        setFragmentResult("dataUser",bundle)
        findNavController().navigate(R.id.action_editProfileFragment_to_settingFragment2)
    }
}
package com.dungtran.androidd20l11.fragment.settingTabView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.MainActivity
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.data.User
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)

        setData()
        setOnClick()

        return binding.root
    }

    private fun setOnClick() {
        binding.btnSave.setOnClickListener {
            clickSaveButton()
        }
    }

    private fun setData() {
        val bundle = arguments?.getSerializable("data_user") as User

        binding.edtYourName.setText(bundle.name)
        binding.edtYourPhoneNumber.setText(bundle.phoneNumber)
        binding.edtYourEmail.setText(bundle.gmail)
    }

    private fun clickSaveButton() {
        val bundle = Bundle()
        val newUser = User(
            binding.edtYourName.text.toString(),
            binding.edtYourPhoneNumber.text.toString(),
            binding.edtYourEmail.text.toString()
        )

        bundle.putSerializable(
            "user",
            newUser
        )

        (activity as MainActivity).updateUser(newUser)

        setFragmentResult("result_for_setting_fragment", bundle)

        findNavController().navigate(R.id.action_editProfileFragment_to_settingFragment)
    }
}
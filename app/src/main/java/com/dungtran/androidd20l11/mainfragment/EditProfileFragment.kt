package com.dungtran.androidd20l11.mainfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        binding.btnSaveProfile.setOnClickListener { view: View ->
            val bundle = Bundle()
            bundle.putString("name", binding.etYourName.text.toString())
            bundle.putString("email", binding.etYourEmail.text.toString())
            bundle.putString("phone", binding.etYourPhoneNumber.text.toString())
            view.findNavController().navigate(R.id.action_editProfileFragment_to_settingFragment, bundle)
        }

        return binding.root
    }
}
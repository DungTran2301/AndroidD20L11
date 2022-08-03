package com.dungtran.androidd20l11.fragment

import android.icu.text.RelativeDateTimeFormatter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding
import com.dungtran.androidd20l11.models.User

class EditProfileFragment : Fragment() {
    private lateinit var binding: FragmentEditProfileBinding;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        onClick()
    }


    private fun loadData() {
        val bundle = arguments?.getSerializable("user") as User
        binding.apply {
            edtEmail.setText(bundle.email)
            edtYourName.setText(bundle.username)
            edtPhoneNumber.setText(bundle.phoneNumber)
        }
    }

    fun onClick() {
        binding.btnSave.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(
                "user",
                User(
                    binding.edtEmail.text.toString(),
                    binding.edtPhoneNumber.text.toString(),
                    binding.edtYourName.text.toString()
                )
            )
            findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment, bundle)
        }
    }
}






























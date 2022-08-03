package com.dungtran.androidd20l11.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding
import com.dungtran.androidd20l11.databinding.FragmentProfileBinding
import com.dungtran.androidd20l11.models.User

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        onClick()
    }

    private fun onClick() {
        val bundle = Bundle()
        bundle.putSerializable(
            "user",
            User(
                binding.tvEmail.text.toString(),
                binding.tvPhoneNumber.text.toString(),
                binding.tvYourName.text.toString()
            )
        )
        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment, bundle)
        }
    }

    private fun loadData() {
        arguments?.let {
            val bundle = it.getSerializable("user") as User
            binding.apply {
                tvEmail.text = bundle.email
                tvPhoneNumber.text = bundle.phoneNumber
                tvYourName.text = bundle.username
            }
        }
    }

}
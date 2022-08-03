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
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        setInFor()
        setCLickListeners()
        return binding.root
    }

    private fun setCLickListeners() {
        binding.txvSave.setOnClickListener{
            val newUser = User(
                binding.edtName.text.toString(),
                binding.edtPhone.text.toString(),
                binding.edtMail.text.toString()
            )
            (activity as MainActivity).setUser(newUser)
            findNavController().navigate(R.id.action_editProfileFragment_to_yourProfileFragment)
        }
    }

    private fun setInFor() {
        val bundle = arguments?.getSerializable("data") as User
        binding.edtName.setText(bundle.name)
        binding.edtPhone.setText(bundle.phone)
        binding.edtMail.setText(bundle.email)
    }

}
package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.constants.Keys
import com.dungtran.androidd20l11.databinding.FragmentEditUserBinding
import com.dungtran.androidd20l11.model.User

class EditUserFragment : Fragment() {
    private lateinit var binding: FragmentEditUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditUserBinding.inflate(inflater)

        setUpClickListeners()
        setUpUserDetail()

        return binding.root
    }

    private fun setUpClickListeners() {
        binding.etSaveUser.setOnClickListener {
            saveButtonClick()
        }
    }

    private fun saveButtonClick() {
        val username = binding.etUserName.editText?.text.toString()
        val telephone = binding.etUserTelephone.editText?.text.toString()
        val email = binding.etUserEmail.editText?.text.toString()

        askActivityToUpdateUser(username, telephone, email)
        setFragmentResult(Keys.USER_UPDATED, bundleOf())
        findNavController().navigate(R.id.action_editUserFragment_to_settingFragment)
    }

    private fun setUpUserDetail() {
        val user = arguments?.getSerializable(Keys.USER_INSTANCE) as User
        binding.apply {
            etUserName.editText?.setText(user.name)
            etUserTelephone.editText?.setText(user.telephone)
            etUserEmail.editText?.setText(user.email)
        }
    }

    private fun askActivityToUpdateUser(username: String, telephone: String, email: String) {
        (activity as MainActivity).updateUser(
            User(username, telephone, email)
        )
    }
}
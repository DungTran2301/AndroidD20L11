package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding


class EditProfileFragment : Fragment() {
    private lateinit var _binding: FragmentEditProfileBinding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        backToSettingFragment()
        return binding.root
    }

    private fun backToSettingFragment() {

        binding.btnEdit.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            val name = binding.txtName.text.toString()
            val phone = binding.txtPhoneNumber.text.toString()
            if (name.isEmpty()) Toast.makeText(
                context,
                "Name    must not be empty",
                Toast.LENGTH_SHORT
            ).show()
            else if (phone.isEmpty()) Toast.makeText(
                context,
                "Phone Number must not be empty",
                Toast.LENGTH_SHORT
            ).show()
            else if (email.isEmpty()) Toast.makeText(
                context,
                "Email must not be empty",
                Toast.LENGTH_SHORT
            ).show()
            else if (!isEmailValid(email)) Toast.makeText(
                context,
                "You did not enter email in the right way!",
                Toast.LENGTH_LONG
            ).show()
            else {
                Toast.makeText(
                    context,
                    "Saved!",
                    Toast.LENGTH_SHORT
                ).show()

                val user = User(name, phone, email)
                val action = EditProfileFragmentDirections.navigateToSettingFragment(user)
                Navigation.findNavController(it).navigate(action)
            }

        }
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
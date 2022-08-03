package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import User
import android.widget.TextView
import androidx.fragment.app.setFragmentResult
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {
    private lateinit var binding: FragmentEditProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_profile,container,false)
        binding = FragmentEditProfileBinding.inflate(inflater)
        val btSave = view.findViewById<Button>(R.id.btsave)
        btSave.setOnClickListener{
            val name = binding.edtname.text.toString()
            val number = binding.edtphonenumber.text.toString()
            val email = binding.edtemail.text.toString()
            val user = User(name,number,email)
            val bundle = Bundle()
            bundle.putSerializable(
                "data",
                user
            )
            setFragmentResult("result_for_setting_fragment", bundle)
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.flfragmentContent, TabSettingFragment())
                addToBackStack(null)
                commit()
            }
        }
        return view
    }

}
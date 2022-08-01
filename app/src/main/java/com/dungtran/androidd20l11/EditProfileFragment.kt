package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import User
import androidx.fragment.app.setFragmentResult
import androidx.navigation.Navigation
import com.dungtran.androidd20l11.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit_profile,container,false)

        val btSave = view.findViewById<Button>(R.id.btsave)
        btSave.setOnClickListener{
            val name = getView()?.findViewById<EditText>(R.id.edtname)
            val number = getView()?.findViewById<EditText>(R.id.edtphonenumber)
            val email = getView()?.findViewById<EditText>(R.id.edtemail)
            val user = User(name?.text.toString(),number?.text.toString(),email?.text.toString())
            val bundle = Bundle()
            bundle.putSerializable(
                "data",
                user
            )
            (activity as MainActivity).updateUser(user)
            setFragmentResult("result_for_setting_fragment", bundle)
            getFragmentManager()?.beginTransaction()?.apply {
                replace(R.id.flfragmentContent, TabSettingFragment())
                commit()
            }
        }
        return view
    }

}
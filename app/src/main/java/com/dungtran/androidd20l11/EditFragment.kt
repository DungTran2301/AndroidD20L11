package com.dungtran.androidd20l11

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.databinding.FragmentEditBinding

class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater,container,false)

        setInfor()
        setCLickListeners()
        return binding.root
    }

    private fun setCLickListeners(){
        binding.btnSave.setOnClickListener {
            saveBtnClick()
        }
    }

    private fun setInfor(){
        val bundle = arguments?.getSerializable("data") as User

        binding.etName.setText(bundle.name)
        binding.etPhone.setText(bundle.phone)
        binding.etEmail.setText(bundle.email)
    }

    private fun saveBtnClick(){
        val bundle = Bundle()
        val newUser = User(
            binding.etName.text.toString(),
            binding.etPhone.text.toString(),
            binding.etEmail.text.toString()
        )
        bundle.putSerializable("user",newUser)
        (activity as MainActivity).updateUser(newUser)
        setFragmentResult("result_setting_fragment",bundle)
        findNavController().navigate(R.id.action_editFragment_to_settingFragment)

    }
}
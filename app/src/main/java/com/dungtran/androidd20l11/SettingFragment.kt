package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater,container,false)
        setInfor((activity as MainActivity).getUser())
        setClickListeners()
        return binding.root
    }

    private fun setInfor(user:User){
        binding.tvName.text = user.name
        binding.tvPhone.text = user.phone
        binding.tvEmail.text = user.email
    }

    private fun setClickListeners(){
        binding.btnEdit.setOnClickListener {
            editBtnClick()
        }
    }

    private fun editBtnClick(){
        val bundle = Bundle()
        bundle.putSerializable(
            "data",
            User(
                binding.tvName.text.toString(),
                binding.tvPhone.text.toString(),
                binding.tvEmail.text.toString()
            )
        )
        findNavController().navigate(
            R.id.action_settingFragment_to_editFragment,
            bundle
        )
    }
}
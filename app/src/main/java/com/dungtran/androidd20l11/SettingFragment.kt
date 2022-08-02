package com.dungtran.androidd20l11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding

    private var user = User("Jessica","0981234567","jessica098@gmail.com")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentSettingBinding.inflate(inflater,container,false)
        getData()
        setData(user)
        binding.btnProfile.setOnClickListener {
            clickOn()
        }
        return binding.root
    }

    private fun getData() {
        setFragmentResultListener("dataUser"){_,bundle->
            user = bundle.getSerializable("user") as User

        }
    }

    private fun clickOn() {
        val bundle = Bundle()
        bundle.putSerializable(
            "data_user",
            User(
                binding.userName.text.toString(),
                binding.phoneNum.text.toString(),
                binding.email.text.toString()
            )
        )
        findNavController().navigate(R.id.action_settingFragment2_to_editProfileFragment,bundle)
    }

    private fun setData(user: User) {
        binding.userName.text = user.userName
        binding.phoneNum.text = user.phoneNum
        binding.email.text = user.email
    }


}
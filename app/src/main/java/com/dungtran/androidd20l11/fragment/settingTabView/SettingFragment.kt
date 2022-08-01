package com.dungtran.androidd20l11.fragment.settingTabView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.MainActivity
import com.dungtran.androidd20l11.R
import com.dungtran.androidd20l11.data.User
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater, container, false)

        setFragmentResultListener("result_for_setting_fragment") { _, bundle ->
            setData(bundle.getSerializable("user") as User)
        }

        setData((activity as MainActivity).getUser())

        setOnClick()

        return binding.root
    }

    private fun setData(user: User) {
        binding.tvYourName.text = user.name
        binding.tvYourPhoneNumber.text = user.phoneNumber
        binding.tvYourEmail.text = user.gmail
    }

    private fun setOnClick() {
        binding.btnEdit.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(
                "data_user",
                User(
                    binding.tvYourName.text.toString(),
                    binding.tvYourPhoneNumber.text.toString(),
                    binding.tvYourEmail.text.toString()
                )
            )

            findNavController().navigate(
                R.id.action_settingFragment_to_editProfileFragment,
                bundle
            )
        }
    }
}
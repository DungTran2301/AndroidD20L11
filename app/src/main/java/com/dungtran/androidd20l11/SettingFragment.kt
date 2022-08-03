package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.dungtran.androidd20l11.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {
    private lateinit var _binding: FragmentSettingBinding
    private val binding get() = _binding!!
    private val args:  SettingFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateText()
    }

    private fun updateText() {
        binding.txtPhoneNumber.text= args.profile?.phone
        binding.txtName.text= args.profile?.name
        binding.txtEmail.text= args.profile?.email
        binding.btnEdit.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.navigateToEditProfileFragment)
        }
    }


}
package com.dungtran.androidd20l11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dungtran.androidd20l11.databinding.FragmentYourProfileBinding

class YourProfileFragment : Fragment() {
    private lateinit var binding : FragmentYourProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYourProfileBinding.inflate(inflater,container,false)
        setInFor((activity as MainActivity).getUser())
        setClickListeners()
        return binding.root
    }

    private fun setClickListeners() {
        binding.txvEdit.setOnClickListener{
            val bundle = Bundle()
            bundle.putSerializable(
                "data",
                User(
                    binding.txvName.text.toString(),
                    binding.txvPhone.text.toString(),
                    binding.txvMail.text.toString()
                )
            )
            findNavController().navigate(R.id.action_yourProfileFragment_to_editProfileFragment,bundle)
        }
    }

    private fun setInFor(user: User) {
        binding.txvName.text = user.name
        binding.txvPhone.text = user.phone
        binding.txvMail.text = user.email
    }

}
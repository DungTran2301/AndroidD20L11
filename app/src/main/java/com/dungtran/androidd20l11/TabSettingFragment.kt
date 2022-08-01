package com.dungtran.androidd20l11

import User
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener

class TabSettingFragment : Fragment(R.layout.fragment_tab_setting) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab_setting,container,false)
        val tvname=view.findViewById<TextView>(R.id.tvname)
        val tvphonenumber=view.findViewById<TextView>(R.id.tvphonenumber)
        val tvemail=view.findViewById<TextView>(R.id.tvemail)
        setFragmentResultListener("result_for_setting_fragment") { _, bundle ->
            val inputdata= bundle.getSerializable("data") as User
            tvname.text=inputdata.name
            tvphonenumber.text=inputdata.phoneNumber
            tvemail.text=inputdata.email
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btedit = getView()?.findViewById<Button>(R.id.btedit)
        btedit?.setOnClickListener{
            getFragmentManager()?.beginTransaction()?.apply {
                replace(R.id.flfragmentContent, EditProfileFragment())
                commit()
            }
        }

    }
}
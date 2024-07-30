package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.R
import com.example.hayatwallet.TokenId
import com.example.hayatwallet.databinding.FragmentPersonInfoBinding
import com.example.hayatwallet.databinding.FragmentWalletBinding


class PersonInfo : Fragment() {

    private val binding get() = _binding!!
    private var _binding : FragmentPersonInfoBinding? = null
    private var fullName : TextView? = null
    private var phoneNumber : TextView? = null
    private var email : TextView? = null
    private val personVM : PersonInfoViewModel by viewModels()
    private var imgBack : ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPersonInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        fullName = binding.fullName
//        phoneNumber = binding.phoneNumber
//        email = binding.email
        val token = TokenId.token
        personVM.getPersonInfo("Bearer $token")
        handleResponse()

    }
    private fun handleResponse(){
        personVM.personInfo.observe(viewLifecycleOwner,Observer{ item ->
            binding.fullNameItem.updateUI("Ad Soyad",item?.item?.firstName + " " + item?.item?.lastName)
            binding.phoneNumberItem.updateUI("Telefon Numarası",item?.item?.phoneNumber.toString())
            binding.emailItem.updateUI("Email",item?.item?.email.toString())
//            fullName?.text = item?.item?.firstName + " " + item?.item?.lastName
//            phoneNumber?.text = item?.item?.phoneNumber
//            email?.text = item?.item?.email
        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            PersonInfo().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
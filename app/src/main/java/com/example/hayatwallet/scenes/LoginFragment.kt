package com.example.hayatwallet.scenes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.NameSharedPreference
import com.example.hayatwallet.Network.Response.LoginResponse
import com.example.hayatwallet.R
import com.example.hayatwallet.TokenId
import com.example.hayatwallet.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var loginButton:Button? = null
    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginVM : LoginFragmentViewModel by viewModels()
    private var editTextMusteriNo : EditText? = null
    private var editTextPassword : EditText? = null
    private var responseResult:LoginResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NameSharedPreference.init(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextMusteriNo = binding.musteriNo
        editTextPassword = binding.password
        loginButton = binding.loginButton

        loginButton?.setOnClickListener{
//                val userName = editTextMusteriNo?.text.toString()
//                val password = editTextPassword?.text.toString()
            val userName = "ararat2@oktein.com"
            val password = "123456789Aa@"

            loginVM.login(userName,password)
            handleResponse(userName)


        }
    }
    private fun handleResponse(userName : String? ){
        loginVM.isLogged.observe(viewLifecycleOwner, Observer { item ->
            if(item?.isSuccess == true){
                TokenId.token = item.token
                NameSharedPreference.saveUsername(userName)
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToTabLayoutFragment())
            }else{
                editTextPassword!!.setText("")
                editTextMusteriNo!!.setText("")
                Toast.makeText(context, "Kullanıcı Adı veya Şifre Hatalı", Toast.LENGTH_SHORT).show()
            }
        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    
                }
            }
    }
}
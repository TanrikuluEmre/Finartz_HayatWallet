package com.example.hayatwallet.scenes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.NameSharedPreference
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentAlreadyLoggedBinding
import com.example.hayatwallet.databinding.FragmentLoginBinding


class AlreadyLoggedFragment : Fragment() {

    private var _binding : FragmentAlreadyLoggedBinding? = null
    private val binding get() = _binding!!
    private lateinit var passwordEditText : EditText
    private lateinit var userNameTextView : TextView
    private val loginVM : LoginFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NameSharedPreference.init(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAlreadyLoggedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passwordEditText = binding.password
        userNameTextView = binding.userName
        var userName : String? = NameSharedPreference.getUsername()
        passwordEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(passwordEditText.length() >= 12){
                    loginVM.login(userName,passwordEditText.text.toString())
                    handleResponse()

                }
            }
        })

    }
    private fun handleResponse(){
        loginVM.isLogged.observe(viewLifecycleOwner, Observer { item ->
            if(item?.isSuccess == true){
                findNavController().navigate(AlreadyLoggedFragmentDirections.actionAlreadyLoggedFragmentToTabLayoutFragment())
            }else{
                passwordEditText.setText("")
                Toast.makeText(context, "Şifre Hatalı", Toast.LENGTH_SHORT).show()
            }
        })
    }
    companion object {

        @JvmStatic
        fun newInstance( ) =
            AlreadyLoggedFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
package com.example.hayatwallet.scenes

import WelcomeFragmentViewModel
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat.Style
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.NameSharedPreference
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding : FragmentWelcomeBinding
    private lateinit var textHayatFinans : TextView
    private lateinit var textXDakikada : TextView
    private lateinit var alreadyCustomerButton : Button
    private val welcomeVM : WelcomeFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NameSharedPreference.init(this.requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textHayatFinans = binding.texthayatfinans
        textXDakikada = binding.textXDakikada
        alreadyCustomerButton = binding.alreadyCustomerButton


        var text1 = "Hayat Finans'a"
//        welcomeVM.normal("Hayat Finans'".length,text1.length,text1,textHayatFinans)
        var text2 = "X Dakikada birbirimizi tanıyıp Hayat Finans\ndünyasının müşterisi olabilirsiniz."
        welcomeVM.bold(0,"X Dakikada".length,text2,textXDakikada)

//                                          SHARED PREFERENCES
//
//        alreadyCustomerButton.setOnClickListener{
//            Log.d("TAG", "onViewCreated: ${NameSharedPreference.getUsername()}")
//            if(NameSharedPreference.getUsername() == "" || NameSharedPreference.getUsername() == null){
//                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment())
//            }else{
//                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToAlreadyLoggedFragment())
//            }
//
//        }

        alreadyCustomerButton.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment())
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            WelcomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
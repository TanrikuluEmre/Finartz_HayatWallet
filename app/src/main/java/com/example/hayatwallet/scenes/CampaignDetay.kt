package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.hayatwallet.Network.Response.CampaignData
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentCampaignDetayBinding


class CampaignDetay : Fragment() {

    private var _binding : FragmentCampaignDetayBinding? = null
    private val binding get() = _binding!!
    private var title : String? = null
    private var imgUrl : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            title = it?.getString("title")
            imgUrl = it?.getString("img")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentCampaignDetayBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgBack.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_campaignDetay_to_tabLayoutFragment)
        }
        binding.titleDetay.text = title
        Glide.with(view.context).load(imgUrl).into(binding.imgCampaignDetay)

    }

    companion object {

        @JvmStatic
        fun newInstance( ) =
            CampaignDetay().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
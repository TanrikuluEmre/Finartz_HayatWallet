package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.Network.Response.CampaignData
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentCampaignBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CampaignFragment : Fragment() {

    private var _binding : FragmentCampaignBinding? = null
    private val binding get() = _binding!!
    private val CampaignViewModel = CampaignViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment

        _binding = FragmentCampaignBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       CampaignViewModel.getData { campaigns ->
            setUpAdapter(campaigns)
       }


    }
    private fun setUpAdapter(result : List<CampaignData>){
        val campiagnAdapter = CampaignAdapter(result)
        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = campiagnAdapter
    }

    companion object {

        @JvmStatic
        fun newInstance( ) =
            CampaignFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
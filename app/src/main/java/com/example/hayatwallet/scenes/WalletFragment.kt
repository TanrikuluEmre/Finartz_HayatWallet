package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.NameSharedPreference
import com.example.hayatwallet.Network.Response.CampaignData
import com.example.hayatwallet.Network.Response.TransactionSummary
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentWalletBinding

class WalletFragment : Fragment() {

    private var _binding : FragmentWalletBinding? = null
    private val binding get() = _binding!!
    private var transactionListAll: MutableList<TransactionSummary> = mutableListOf()
    private var transactionList: MutableList<TransactionSummary> = mutableListOf()
    private var walletVM : WalletFragmentViewmodel? = null
    private var campaignVM : CampaignViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        walletVM = WalletFragmentViewmodel()
        campaignVM = CampaignViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWalletBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBack.setOnClickListener{
            findNavController().navigate(TabLayoutFragmentDirections.actionTabLayoutFragmentToLoginFragment())
            NameSharedPreference.clearUsername()
        }

        transactionListAll = walletVM?.getTransactionList()!!
        transactionControl()
        setUpAdapter(transactionList)

        campaignVM?.getData { campaigns ->
                setUpAdapterCampaign(campaigns)
        }


        binding.seeAll.setOnClickListener {
            val transactionListAllArray = ArrayList(transactionListAll)

            val bundle = Bundle().apply {
                putSerializable("transactionList", transactionListAllArray)
            }

            findNavController().navigate(R.id.action_tabLayoutFragment_to_walletTransaction, bundle)
        }


    }

    private fun setUpAdapter(result : List<TransactionSummary>?){
        if(result != null) {
            val transactionAdapter = TransactionAdapter(result)
            val recyclerview = binding.recyclerview
            recyclerview.layoutManager = LinearLayoutManager(activity)
            recyclerview.adapter = transactionAdapter
        }
    }
    private fun setUpAdapterCampaign(result : List<CampaignData>){
        val campiagnAdapter = WalletHorizontalCampaign(result)
        val recyclerview = binding.recyclerCampaign
        recyclerview.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        recyclerview.adapter = campiagnAdapter
    }
    private fun transactionControl(){
        if(transactionListAll.size <= 3){
            transactionList = transactionListAll
        }else {
            transactionList.add(transactionListAll[transactionListAll.size - 1])
            transactionList.add(transactionListAll[transactionListAll.size - 2])
            transactionList.add(transactionListAll[transactionListAll.size - 3])
        }
    }


    companion object {

        @JvmStatic
        fun newInstance( ) =
            WalletFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
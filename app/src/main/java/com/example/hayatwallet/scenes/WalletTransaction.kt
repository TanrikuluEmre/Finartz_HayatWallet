package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.Network.Response.TransactionSummary
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentWalletBinding
import com.example.hayatwallet.databinding.FragmentWalletTransactionBinding


class WalletTransaction : Fragment() {

    private var _binding : FragmentWalletTransactionBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentWalletTransactionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transactionList = arguments?.getSerializable("transactionList") as List<TransactionSummary>
        setUpAdapter(transactionList)
    }

    private fun setUpAdapter(result : List<TransactionSummary>?){
        val transactionAdapter = TransactionAdapter(result)
        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = transactionAdapter
    }
    companion object {

        @JvmStatic
        fun newInstance( ) =
            WalletTransaction().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
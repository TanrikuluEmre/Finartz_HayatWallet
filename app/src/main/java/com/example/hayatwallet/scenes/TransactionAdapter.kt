package com.example.hayatwallet.scenes

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hayatwallet.Network.Response.TransactionSummary
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.CampaignAdapterBinding
import com.example.hayatwallet.databinding.TransactionCustomviewBinding
import com.example.hayatwallet.scenes.CampaignAdapter.ViewHolder

class TransactionAdapter(val transactionList : List<TransactionSummary>?) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    class ViewHolder(val binding: TransactionCustomviewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TransactionCustomviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.binding.imageView3.context).load(transactionList?.get(position)?.img).into(holder.binding.imageView3)
        holder.binding.company.text = transactionList?.get(position)?.company
        holder.binding.hours.text = transactionList?.get(position)?.hours
        holder.binding.price.text = transactionList?.get(position)?.price
    }

    override fun getItemCount(): Int {
        return transactionList?.size ?: 0
    }

}
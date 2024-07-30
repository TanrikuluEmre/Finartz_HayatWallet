package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.core.infiniteRepeatable
import androidx.recyclerview.widget.RecyclerView
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.CampaignAdapterBinding

class CampaignAdapter : RecyclerView.Adapter<CampaignAdapter.ViewHolder>() {

    class ViewHolder(private val binding: CampaignAdapterBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CampaignAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }






}
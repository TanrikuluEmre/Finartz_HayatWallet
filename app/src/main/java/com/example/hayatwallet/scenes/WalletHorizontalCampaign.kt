package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hayatwallet.Network.Response.CampaignData
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.CampaignAdapterBinding
import com.example.hayatwallet.databinding.FragmentWalletHorizontalCampaignBinding
import com.example.hayatwallet.scenes.CampaignAdapter.ViewHolder


class WalletHorizontalCampaign(private val campignDatas : List<CampaignData>) : RecyclerView.Adapter<WalletHorizontalCampaign.ViewHolder>() {

    class ViewHolder(val binding: FragmentWalletHorizontalCampaignBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentWalletHorizontalCampaignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(campignDatas[position].img).into(holder.binding.campaignImg)
        holder.binding.campaignText.text = campignDatas[position].title
        holder.binding.campaignImg.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("title",campignDatas[position].title)
            bundle.putString("img",campignDatas[position].img)
            Navigation.findNavController(it).navigate(R.id.action_tabLayoutFragment_to_campaignDetay,bundle)
        }
    }

    override fun getItemCount(): Int {
        return campignDatas.size
    }
}
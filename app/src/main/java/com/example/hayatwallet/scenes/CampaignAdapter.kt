package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.compose.animation.core.infiniteRepeatable
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.hayatwallet.Network.Response.CampaignData
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.CampaignAdapterBinding

class CampaignAdapter(private val campignDatas : List<CampaignData>) : RecyclerView.Adapter<CampaignAdapter.ViewHolder>() {

    class ViewHolder(val binding: CampaignAdapterBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CampaignAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return campignDatas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.binding.title.text = campignDatas[position].title
        Glide.with(holder.itemView.context).load(campignDatas[position].img).into(holder.binding.imgCampaign)
        holder.binding.detayButton.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("title",campignDatas[position].title)
            bundle.putString("img",campignDatas[position].img)
            Navigation.findNavController(it).navigate(R.id.action_tabLayoutFragment_to_campaignDetay,bundle)
        }
    }






}
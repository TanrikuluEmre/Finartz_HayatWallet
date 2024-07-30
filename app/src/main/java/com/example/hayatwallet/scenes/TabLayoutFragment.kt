package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentTabLayoutBinding


class TabLayoutFragment : Fragment() {

    private var _binding : FragmentTabLayoutBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTabLayoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPageAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        binding.homeTxt.setOnClickListener {
            makeAllGrey()
            binding.homeTxt.background = resources.getDrawable(R.color.grey,resources.newTheme())
            binding.viewPager.currentItem = 0
        }

        binding.campaingTxt.setOnClickListener {
            makeAllGrey()
            binding.campaingTxt.background = resources.getDrawable(R.color.grey,resources.newTheme())
            binding.viewPager.currentItem = 1
        }

        binding.personTxt.setOnClickListener {
            makeAllGrey()
            binding.personTxt.background = resources.getDrawable(R.color.grey,resources.newTheme())
            binding.viewPager.currentItem = 2
        }


    }
    fun makeAllGrey(){
        binding.homeTxt.background = resources.getDrawable(R.color.backgroundGrey,resources.newTheme())
        binding.campaingTxt.background = resources.getDrawable(R.color.backgroundGrey,resources.newTheme())
        binding.personTxt.background = resources.getDrawable(R.color.backgroundGrey,resources.newTheme())
    }
    companion object {

        @JvmStatic
        fun newInstance( ) =
            TabLayoutFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
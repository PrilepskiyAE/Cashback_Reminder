package com.cashbackreminder.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cashbackreminder.BaseFragment
import com.cashbackreminder.MainActivity
import com.cashbackreminder.ViewPagerFragmentStateAdapter
import com.cashbackreminder.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            requireActivity().finish()
        }
    }
}
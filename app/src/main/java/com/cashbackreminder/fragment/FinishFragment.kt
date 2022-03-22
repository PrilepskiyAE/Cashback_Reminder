package com.cashbackreminder.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.cashbackreminder.BaseFragment
import com.cashbackreminder.MainActivity
import com.cashbackreminder.databinding.FragmentFinishBinding
import com.cashbackreminder.databinding.FragmentMainBinding


class FinishFragment : BaseFragment<FragmentFinishBinding>() {


    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFinishBinding {
        return  FragmentFinishBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button3.setOnClickListener {
            requireActivity().finish()
        }
    }
}
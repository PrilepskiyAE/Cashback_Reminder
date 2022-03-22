package com.cashbackreminder.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cashbackreminder.BaseFragment
import com.cashbackreminder.MainActivity
import com.cashbackreminder.ViewPagerFragmentStateAdapter
import com.cashbackreminder.databinding.FragmentMainBinding
import com.cashbackreminder.databinding.FragmentStartBinding


class StartFragment : BaseFragment<FragmentStartBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val test:Boolean=false
//проверка есть ли приложение

        if(test)
        {
            val viewPager = (requireActivity() as MainActivity).binding.myPage

            (viewPager.adapter as ViewPagerFragmentStateAdapter).apply {
                val mainFragment = fragments[1]
                fragments.remove(mainFragment)
                viewPager.post {
                    notifyItemRemoved(1)
                }

            }
        }
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentStartBinding {
        return FragmentStartBinding.inflate(layoutInflater, container, false)
    }


}
package com.cashbackreminder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.random.Random


abstract class BaseFragment<T: ViewBinding> : Fragment() {
    val pageId = Random.nextLong(2021, 2021*3)
    var pagePos = -1
    private var _binding: T? = null
    val binding:T
        get() = _binding?: throw NullPointerException("Erorr Binding!!!")


    abstract fun getBinding(inflater: LayoutInflater,container: ViewGroup?): T


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getBinding(inflater, container)
        return _binding!!.root
    }


}
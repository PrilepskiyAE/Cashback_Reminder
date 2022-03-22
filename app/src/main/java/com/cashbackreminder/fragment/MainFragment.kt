package com.cashbackreminder.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cashbackreminder.BaseFragment
import com.cashbackreminder.databinding.FragmentMainBinding

import com.google.firebase.ktx.Firebase


import com.google.firebase.storage.ktx.storage


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        val  storage = Firebase.storage
       // var storageRef = storage.reference
        //val pathReference = storageRef.child("images/test.apk")
      //  val gsReference = storage.getReferenceFromUrl("gs://message-543c9.appspot.com/APKPure_v3.17.42_apkpure.com.apk")
        //val httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/message-543c9.appspot.com/o/APKPure_v3.17.42_apkpure.com.apk")
        binding.button.setOnClickListener {
            requireActivity().finish()
        }
binding.button2.setOnClickListener {
    val gsReference = storage.getReferenceFromUrl("gs://message-543c9.appspot.com/APKPure_v3.17.42_apkpure.com.apk")
}

    }
}
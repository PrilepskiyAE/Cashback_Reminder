package com.cashbackreminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.cashbackreminder.databinding.ActivityMainBinding
import com.cashbackreminder.fragment.FinishFragment
import com.cashbackreminder.fragment.MainFragment
import com.cashbackreminder.fragment.StartFragment

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.myPage.adapter=ViewPagerFragmentStateAdapter(this,
            mutableListOf(
                StartFragment(),
                MainFragment(),
                FinishFragment()
            )
        )


    }
}
package com.cashbackreminder

import androidx.viewbinding.ViewBinding

interface FragmentReplacer {
    fun replace(
        position: Int,
        newFragment: BaseFragment<out ViewBinding>,
        isNotify: Boolean = true
    )
    fun replaceDef(position: Int, isNotify: Boolean = true) : BaseFragment<out ViewBinding>
    fun replaceCurrentToDef()

    var lastReplacedPos: Int
}
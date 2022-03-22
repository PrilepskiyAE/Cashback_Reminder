package com.cashbackreminder.fragment

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cashbackreminder.BaseFragment
import com.cashbackreminder.MainActivity
import com.cashbackreminder.ViewPagerFragmentStateAdapter
import com.cashbackreminder.databinding.FragmentStartBinding

class StartFragment : BaseFragment<FragmentStartBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val test:Boolean=false
//проверка есть ли приложение

        if(chekApp())
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

@SuppressLint("QueryPermissionsNeeded")
fun chekApp():Boolean{
   /* val startupIntent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

    val activities = pm.queryIntentActivities(startupIntent, 0)

    val mainIntent = Intent(Intent.ACTION_MAIN, null)
    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
    val pkgAppsList = context!!.packageManager.queryIntentActivities(mainIntent, 0)

    activities.sortWith(Comparator { a, b ->
        String.CASE_INSENSITIVE_ORDER.compare(
            a.loadLabel(pm).toString(),
            b.loadLabel(pm).toString()
        )
    })

    */
    val pm: PackageManager  = requireContext().packageManager
   val list:List<ApplicationInfo> = pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES)

    for (ln in list){
       // Log.d("TAG1", "chekApp:  var = ${pkgAppsList.size} var2= ${list.size}")
        Log.d("TAG", "chekApp: ${ln.packageName}")
    }



    return false
}

}
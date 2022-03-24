package com.cashbackreminder.fragment


import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import com.cashbackreminder.BaseFragment
import com.cashbackreminder.FileDownloader
import com.cashbackreminder.databinding.FragmentMainBinding
import com.google.firebase.ktx.BuildConfig
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit


class MainFragment : BaseFragment<FragmentMainBinding>() {
    companion object {
        private const val FILE_NAME = "Hamty_1.0.4.2.apk"
        //private const val URL = "https://firebasestorage.googleapis.com/v0/b/cashbackreminder-a1524.appspot.com/o/A17_FlightPlan.pdf?alt=media&token=1afc696d-c489-4a3a-810f-e50219a2cc61"
        private const val URL = "https://firebasestorage.googleapis.com/v0/b/cashbackreminder-a1524.appspot.com/o/Hamty_1.0.4.2.apk?alt=media&token=0aca6b7f-3511-406c-8149-3b8e1338a3f7"
    }
    private var disposable = Disposables.disposed()
    private val fileDownloader by lazy {
        FileDownloader(
            OkHttpClient.Builder().build()
        )
    }

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
    Log.d("TAG228", "Start: ")
    //val gsReference = storage.getReferenceFromUrl("gs://message-543c9.appspot.com/APKPure_v3.17.42_apkpure.com.apk")
    val targetFile = File(requireActivity().cacheDir, FILE_NAME)

    disposable = fileDownloader.download(URL, targetFile)
        .throttleFirst(2, TimeUnit.SECONDS)
        .toFlowable(BackpressureStrategy.LATEST)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            Log.d("TAG228", "$it% Downloaded ")
            Toast.makeText(requireContext(), "$it% Downloaded", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            Log.d("TAG228", "$it.localizedMessage ")
        }, {
            Toast.makeText(requireContext(), "Complete Downloaded", Toast.LENGTH_SHORT).show()
            Log.d("TAG228", "Complete Downloaded ${targetFile.path}")

          //  installAPK("")



        })




}

    }


    fun installAPK(PATH:String) {
        //val PATH = Environment.getExternalStorageDirectory().toString() + "/" + "apkname.apk"
        val file = File(PATH)
        if (file.exists()) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(
                uriFromFile(
                    requireContext().getApplicationContext(),
                    File(PATH)
                ), "application/vnd.android.package-archive"
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            try {
                requireContext().startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
                Log.e("TAG", "Error in opening the file!")
            }
        } else {
            Toast.makeText(
               requireContext(),
                "installing",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun uriFromFile(context: Context, file: File?): Uri? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(
                context, BuildConfig.APPLICATION_ID.toString() + ".provider",
                file!!
            )
        } else {
            Uri.fromFile(file)
        }

        val intent = Intent(Intent.ACTION_INSTALL_PACKAGE)
        intent.data = Uri.fromFile(File(pathToApk))
        startActivity(intent)
    }




}
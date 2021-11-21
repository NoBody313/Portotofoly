package com.example.pototofoly.ui.android

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pototofoly.R
import com.example.pototofoly.data.android.AndroidObject
import com.example.pototofoly.databinding.FragmentAndroidBinding


private const val GITHUB_LINK = "https://www.dzakyhdr.my.id/"

class AndroidFragment : Fragment() {
    private var _binding: FragmentAndroidBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val androidAdapter = AndroidAdapter()
        androidAdapter.onItemClicked = { selectedData ->
            Toast.makeText(requireContext(), selectedData.title, Toast.LENGTH_SHORT).show()
        }
        androidAdapter.setData(AndroidObject.listAppAndroid)

        with(binding.rvAndroid) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidAdapter
        }
        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            AndroidObject.listAppAndroid.size.toString()
        )


        binding.txtDokumentasi.setOnClickListener {
            CustomTabsIntent.Builder().build()
                .launchUrl(requireContext(), Uri.parse(GITHUB_LINK))
        }


    }


}
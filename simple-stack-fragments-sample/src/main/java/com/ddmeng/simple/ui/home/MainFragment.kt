package com.ddmeng.simple.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ddmeng.simple.databinding.MainFragmentBinding
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import kotlinx.parcelize.Parcelize

@Parcelize // typically data class
class SecondScreen : DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = MainFragment()
}

class MainFragment : KeyedFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val textView: TextView = binding.textView
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }
}
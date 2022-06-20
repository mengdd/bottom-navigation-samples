package com.ddmeng.bottom_navigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ddmeng.bottom_navigation.Detail
import com.ddmeng.bottom_navigation.HomeKey
import com.ddmeng.bottom_navigation.MainActivity
import com.ddmeng.bottom_navigation.databinding.FragmentHomeBinding
import dev.enro.annotations.NavigationDestination
import dev.enro.core.forward
import dev.enro.core.navigationHandle
import java.util.*

@NavigationDestination(HomeKey::class)
class HomeFragment : Fragment() {
    private val navigation by navigationHandle<HomeKey>()
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        textView.setOnClickListener {
            navigation.forward(Detail(UUID.randomUUID().toString()))
        }

        binding.textPush.setOnClickListener {
            (activity as MainActivity).pushToCurrentTab(Detail(UUID.randomUUID().toString()))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
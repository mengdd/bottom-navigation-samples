package com.ddmeng.bottom_navigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ddmeng.bottom_navigation.RootScreen
import com.ddmeng.bottom_navigation.databinding.FragmentHomeBinding
import com.ddmeng.bottom_navigation.navigation.DetailScreen
import com.ddmeng.bottom_navigation.navigation.FragmentStackHost
import com.zhuinden.simplestackextensions.fragmentsktx.lookup

class HomeFragment : Fragment() {
    private val localStack by lazy { lookup<FragmentStackHost>(RootScreen.FIRST_STACK).backstack }
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
            localStack.goTo(DetailScreen())
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
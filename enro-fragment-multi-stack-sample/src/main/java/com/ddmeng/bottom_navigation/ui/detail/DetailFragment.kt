package com.ddmeng.bottom_navigation.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ddmeng.bottom_navigation.Detail
import com.ddmeng.bottom_navigation.HomeKey
import com.ddmeng.bottom_navigation.databinding.FragmentDetailBinding
import dev.enro.annotations.NavigationDestination
import dev.enro.core.forward
import dev.enro.core.navigationHandle
import java.util.*

@NavigationDestination(Detail::class)
class DetailFragment : Fragment() {
    private val navigation by navigationHandle<Detail>()
    private lateinit var detailViewModel: DetailViewModel
    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("detail fragment", "${this.hashCode()} onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("detail fragment", "${this.hashCode()} onCreateView")
        detailViewModel =
            ViewModelProvider(this).get(DetailViewModel::class.java)

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDetail
        detailViewModel.text.observe(viewLifecycleOwner) {
            textView.text = "$it ${this@DetailFragment.hashCode()}"
        }
        textView.setOnClickListener {
            navigation.forward(Detail(UUID.randomUUID().toString()))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("detail fragment", "${this.hashCode()} onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        // When switching tabs, the fragment will be destroyed
        // When switching back, some new fragment will be created instead
        Log.e("detail fragment", "${this.hashCode()} onDestroy")
    }
}
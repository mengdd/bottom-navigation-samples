package com.ddmeng.bottom_navigation.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ddmeng.bottom_navigation.Detail
import com.ddmeng.bottom_navigation.NotificationsKey
import com.ddmeng.bottom_navigation.databinding.FragmentNotificationsBinding
import dev.enro.annotations.NavigationDestination
import dev.enro.core.forward
import dev.enro.core.navigationHandle
import java.util.*

@NavigationDestination(NotificationsKey::class)
class NotificationsFragment : Fragment() {
    private val navigation by navigationHandle<NotificationsKey>()
    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        textView.setOnClickListener {
            navigation.forward(Detail(UUID.randomUUID().toString()))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
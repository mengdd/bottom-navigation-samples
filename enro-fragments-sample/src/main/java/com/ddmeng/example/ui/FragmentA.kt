package com.ddmeng.example.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ddmeng.example.FragmentAKey
import com.ddmeng.example.R
import dev.enro.annotations.NavigationDestination
import dev.enro.core.forward
import dev.enro.core.navigationHandle
import dev.enro.viewmodel.enroViewModels
import java.util.*

@NavigationDestination(FragmentAKey::class)
class FragmentA : Fragment(R.layout.fragment_a) {
    private val navigation by navigationHandle<FragmentAKey>()
    private val viewModel by enroViewModels<FragmentAViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("fragments", "FragmentA ${this.hashCode()} onViewCreated")
        view.findViewById<Button>(R.id.button).setOnClickListener {
            navigation.forward(FragmentAKey(name = UUID.randomUUID().toString(), age = Random().nextInt()))
        }

        view.findViewById<TextView>(R.id.text).text = "Fragment ${this.hashCode()} with ${viewModel.text.value}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fragments", "FragmentA ${this.hashCode()} onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragments", "FragmentA ${this.hashCode()} onDestroy")
    }
}
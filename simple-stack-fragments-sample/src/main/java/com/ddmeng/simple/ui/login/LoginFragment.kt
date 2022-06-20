package com.ddmeng.simple.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ddmeng.simple.ui.home.SecondScreen
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import kotlinx.parcelize.Parcelize

@Parcelize // typically data class
class FirstScreen: DefaultFragmentKey() {
    override fun instantiateFragment(): Fragment = LoginFragment()
}

class LoginFragment : KeyedFragment() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("fragments", "LoginFragment${this.hashCode()} onCreateView")
        binding = FragmentLoginBinding.inflate(inflater)

        val login = binding.login

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)


        login.setOnClickListener {
            backstack.goTo(SecondScreen())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("fragments", "LoginFragment${this.hashCode()} onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragments", "LoginFragment${this.hashCode()} onDestroy")
    }
}
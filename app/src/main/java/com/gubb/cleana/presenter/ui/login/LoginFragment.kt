package com.gubb.cleana.presenter.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gubb.cleana.ApplicationLoader
import com.gubb.cleana.R
import com.gubb.cleana.core.binding.autoCleared
import com.gubb.cleana.databinding.FragmentFirstBinding
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    var binding by autoCleared<FragmentFirstBinding>()

    private val userViewModel: LoginViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity!!.application as ApplicationLoader).appComponent.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentFirstBinding>(
                inflater,
                R.layout.fragment_first,
                container,
                false)


        binding = dataBinding
        binding.lifecycleOwner = this
        binding.viewModel = userViewModel
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.loginSuccessful.observe(activity as AppCompatActivity, Observer {
            if (it)
                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
        })
    }
}
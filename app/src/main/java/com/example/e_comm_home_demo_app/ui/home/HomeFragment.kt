package com.example.e_comm_home_demo_app.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.e_comm_home_demo_app.R
import com.example.e_comm_home_demo_app.data.model.Article
import com.example.e_comm_home_demo_app.databinding.FragmentHomeBinding
import com.example.e_comm_home_demo_app.util.ReponseHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    var TAG = "HomeFragment"

    lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        getData()

        viewModel.mNewsData.value = Article(author = "ABC", description = "This is desc")
        viewModel.saveNews()

        return binding.root
    }

    fun getData() {
        viewModel.mHomeScreenData.observe(viewLifecycleOwner) { response ->

            when (response) {
                is ReponseHandler.Success -> {

//                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        Log.d(TAG, "getData: success: ${newsResponse.defaultCurrency}", )
                    }
                }
                is ReponseHandler.Error -> {

//                    hideProgressBar()
                    response.message?.let { message ->

                        Log.e(TAG, "getData Error: $message")
                        Toast.makeText(context, getString(R.string.something_went_wrong_msg), Toast.LENGTH_SHORT).show()
                    }
                }
                is ReponseHandler.Loading -> {

//                    showProgressBar()
                    Log.e(TAG, "getData: loading...", )
                }
            }
        }
    }
}
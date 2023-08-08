package com.example.e_comm_home_demo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.e_comm_home_demo_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var TAG = "MainActivity"

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
//    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*todo setup bottom navigation*/
        navController = findNavController(R.id.fragment)
        binding.bottomNavigationView.setupWithNavController(navController)

        /*todo required if toolbar name need to be auto set*/
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.prescriptionFragment,R.id.profileFragment,R.id.settingFragment))
    }
}
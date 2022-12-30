package com.udacity.shoestore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.ShoeListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : ShoeListViewModel
    lateinit var appBarConfiguration : AppBarConfiguration
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java] as ShoeListViewModel



        Toast.makeText(this, "size = " + viewModel.list.size, Toast.LENGTH_LONG).show()

        binding.toolbar.inflateMenu(R.menu.overflow_menu)
        binding.toolbar.setOnMenuItemClickListener( Toolbar.OnMenuItemClickListener {
            navController.navigate(R.id.action_shoeListFragment_to_loginFragment)
            true
        })

        hideMenu()
    }




    public fun showMenu() : Unit{
        for(i in 0 until binding.toolbar.menu.size){
            binding.toolbar.menu[i].isVisible = true
        }
    }

    public fun hideMenu() : Unit{
        for(i in 0 until binding.toolbar.menu.size){
            binding.toolbar.menu[i].isVisible = false
        }

    }
}

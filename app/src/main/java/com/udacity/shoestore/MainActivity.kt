package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.core.view.get
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.models.ShoeListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : ViewModel
    lateinit var appBarConfiguration : AppBarConfiguration
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.toolbar.inflateMenu(R.menu.overflow_menu)
        binding.toolbar.setOnMenuItemClickListener( Toolbar.OnMenuItemClickListener { item: MenuItem? ->
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

package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
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
    lateinit var viewModel : ShoeListViewModel
    lateinit var appBarConfiguration : AppBarConfiguration
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java] as ShoeListViewModel

        preloadData()

        Toast.makeText(this, "size = " + viewModel.list.size, Toast.LENGTH_LONG).show()

        binding.toolbar.inflateMenu(R.menu.overflow_menu)
        binding.toolbar.setOnMenuItemClickListener( Toolbar.OnMenuItemClickListener {
            navController.navigate(R.id.action_shoeListFragment_to_loginFragment)
            true
        })

        hideMenu()
    }

    private fun preloadData() {
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name1").setCompany("company1").setDescription("description1").setSize(0.0).setImages(listOf("image1","image2")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name2").setCompany("company2").setDescription("description2").setSize(0.0).setImages(listOf("image3","image4")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name3").setCompany("company3").setDescription("description3").setSize(0.0).setImages(listOf("image5","image6")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name4").setCompany("company4").setDescription("description4").setSize(0.0).setImages(listOf("image7","image8")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name5").setCompany("company5").setDescription("description5").setSize(0.0).setImages(listOf("image9","image10")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name6").setCompany("company6").setDescription("description6").setSize(0.0).setImages(listOf("image11","image12")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name7").setCompany("company7").setDescription("description7").setSize(0.0).setImages(listOf("image13","image14")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name8").setCompany("company8").setDescription("description8").setSize(0.0).setImages(listOf("image15","image16")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name9").setCompany("company9").setDescription("description9").setSize(0.0).setImages(listOf("image17","image18")).build())
        viewModel.addShoe(ShoeListViewModel.newModel().setName("name10").setCompany("company10").setDescription("description10").setSize(0.0).setImages(listOf("image19","image20")).build())

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

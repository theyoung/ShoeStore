package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeListFragment : Fragment(){
    lateinit var binding : FragmentShoeListBinding
    private lateinit var viewModel : ShoeListViewModel
    private lateinit var inflater : LayoutInflater
    private lateinit var parentView : ViewGroup
    private val newValue : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java] as ShoeListViewModel
//        preloadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        this.inflater = inflater
        this.parentView = binding.scrollList;

        (requireActivity() as MainActivity).showMenu()

        viewModel.liveData.observe(viewLifecycleOwner, Observer {
            refreshList()
        })
        binding.floatingActionButton.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeEditFragment(newValue)
            findNavController().navigate(action)
        }
        return binding.root
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
    fun refreshList(){
        parentView.removeAllViews()

        for(i in 0 until viewModel.list.size){
            var shoe : Shoe = viewModel.list[i]
            var shoeBind : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, this.parentView, false)
            shoeBind.shoe = shoe;
            parentView.addView(shoeBind.root);
            shoeBind.root.setOnClickListener {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeEditFragment(i)
                findNavController().navigate(action)
            }
            shoeBind.invalidateAll()
        }

    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).hideMenu()
    }
}
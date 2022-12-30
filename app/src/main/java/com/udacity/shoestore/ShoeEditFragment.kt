package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeEditBinding
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeEditFragment : Fragment() {
    lateinit var binding : FragmentShoeEditBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_edit, container, false)
        val selectedNum = ShoeEditFragmentArgs.fromBundle(requireArguments()).shoeNumber
        this.viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java] as ShoeListViewModel

        if(0 <= selectedNum){
            binding.shoe = viewModel.list[selectedNum]
        } else {
            binding.shoe = ShoeListViewModel.newModel().setName("temp name").setCompany("temp company").setDescription("temp description").setSize(0.0).setImages(listOf("image19","image20")).build()
        }
        return this.binding.root
    }
}
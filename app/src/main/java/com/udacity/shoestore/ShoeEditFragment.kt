package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeEditBinding
import com.udacity.shoestore.models.Converter
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.fragment_shoe_edit.view.*

class ShoeEditFragment : Fragment() {
    lateinit var binding : FragmentShoeEditBinding
    private lateinit var viewModel: ShoeListViewModel
    private var selectedNum : Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_edit, container, false)
        selectedNum = ShoeEditFragmentArgs.fromBundle(requireArguments()).shoeNumber
        this.viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java] as ShoeListViewModel

        if(0 <= selectedNum){
            binding.shoe = viewModel.list[selectedNum]
        } else {
            binding.shoe = ShoeListViewModel.newModel().setName("temp name").setCompany("temp company").setDescription("temp description").setSize(0.0).setImages(listOf("image19","image20")).build()
        }
        binding.saveButton.setOnClickListener {
            savingData(it)
        }
        return this.binding.root
    }

    fun savingData(view : View){
        if(binding.shoe == null) return;
        binding.shoe?.apply {
            name = binding.root.editName.text.toString()
            company = binding.root.editCompany.text.toString()
            description = binding.root.editDesc.text.toString()
            setSize(Converter.stringToDouble(binding.root.editSize.text.toString()))
        }

        if(selectedNum < 0 && binding.shoe != null){
            val nShoe : Shoe = binding.shoe!!
            this.viewModel.addShoe(nShoe)
            selectedNum = this.viewModel.list.size - 1;
        }

        Toast.makeText(context,"Saved Data ${binding.shoe?.name} with ${selectedNum}",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_shoeEditFragment_to_shoeListFragment)
    }
}
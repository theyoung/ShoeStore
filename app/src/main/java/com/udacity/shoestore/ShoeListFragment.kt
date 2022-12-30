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
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeListFragment : Fragment(){
    lateinit var binding : FragmentShoeListBinding
    lateinit var viewModel : ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater)
        (requireActivity() as MainActivity).showMenu()

        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java] as ShoeListViewModel
        var parentView : ViewGroup = binding.scrollList;

        for(shoe: Shoe in viewModel.list){
            var view : ConstraintLayout = inflater.inflate(R.layout.fragment_shoe_detail, parentView, false) as ConstraintLayout
            var name : TextView = view.findViewById(R.id.detail_name)
            name.text = shoe.name

            var company : TextView = view.findViewById(R.id.detail_company)
            company.text = shoe.company
            var desc : TextView = view.findViewById(R.id.detail_desc)
            desc.text = shoe.description
            var size : TextView = view.findViewById(R.id.detail_size)
            size.text = shoe.size.toString()

            parentView.addView(view);
        }

        return binding.root
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).hideMenu()
    }
}
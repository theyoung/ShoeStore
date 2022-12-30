package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {
    companion object {
        fun newModel() : Builder{
            return Builder()
        }
    }

    val list : MutableList<Shoe> = ArrayList<Shoe>()
    val liveData : MutableLiveData<MutableList<Shoe>> = MutableLiveData<MutableList<Shoe>>()

    init {
        liveData.value = list
    }

    public fun addShoe(shoe: Shoe){
        list.add(shoe)
        liveData.value = list;
    }

    class Builder {
        var name : String = ""
        var size : Double = 0.0
        var company : String = ""
        var description : String = ""
        var images : List<String> = mutableListOf()

        fun build() : Shoe {
            return Shoe(name, size, company,description,images)
        }

        fun setName(name:String) :Builder{
            this.name = name
            return this
        }
        fun setSize(size:Double) :Builder{
            this.size = size
            return this
        }
        fun setCompany(company:String) :Builder{
            this.company = company
            return this
        }
        fun setDescription(description:String) :Builder{
            this.description = description
            return this
        }
        fun setImages(list:List<String>):Builder {
            this.images = list;
            return this;
        }
    }
}

package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import com.udacity.shoestore.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, private var size: Double, var company: String, var description: String,val images: List<String> = mutableListOf()) : Observable, Parcelable {

    private val propertyChangeRegistry = PropertyChangeRegistry()
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    @Bindable
    fun getSize(): Double {
        return size
    }
    fun setSize(newSize: Double) {
        if(newSize != size) {
            size = newSize
            propertyChangeRegistry.notifyChange(this, BR.size)
        }
    }
}

package com.monica.ec3_monica_gonzales_.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monica.ec3_monica_gonzales_.data.ListServiceResults
import com.monica.ec3_monica_gonzales_.data.repository.ListRepository
import com.monica.ec3_monica_gonzales_.model.List_
import com.monica.ec3_monica_gonzales_.model.getData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {
    val repository = ListRepository()
    val list: MutableLiveData<List<List_>> = MutableLiveData<List<List_>>()

    fun getList(){
        val  data = getData()
        list.value =data

    }


    fun getListFromService(){
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.getList()
            when (response) {
                is ListServiceResults.Success -> {
                    list.postValue(response.data.lista)
                }
                is ListServiceResults.Error ->{
                    //sirve para pasar el error a otro lado
                }
            }
        }
    }
}
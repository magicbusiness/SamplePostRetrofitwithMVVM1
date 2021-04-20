package com.example.samplepostretrofitwithmvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplepostretrofitwithmvvm.model.ModuleRetro
import com.example.samplepostretrofitwithmvvm.repository.RepositoryData
import kotlinx.coroutines.launch
import retrofit2.Response

class MainView(private val repositoryData: RepositoryData): ViewModel()
{
    // Implement Mutable Live Data
    var dataJSON: MutableLiveData<Response<ModuleRetro>> = MutableLiveData()

    //
    fun postForm(userId: Int, id: Int, title: String, body: String)
    {
        viewModelScope.launch {
            val responseForm = repositoryData.postForm(userId, id, title, body)

            dataJSON.value = responseForm
        }
    }

    fun postPut(post: ModuleRetro)
    {
        viewModelScope.launch {
            val responsePut = repositoryData.postPut(post)

            dataJSON.value = responsePut
        }
    }

    fun postPatch(post: ModuleRetro)
    {
        viewModelScope.launch {
            val repositoryPatch = repositoryData.postPatch(post)

            dataJSON.value = repositoryPatch
        }
    }

    fun postDelete(id: Int)
    {
        viewModelScope.launch {
            val repositoryDelete = repositoryData.postDelete(id)

            dataJSON.value = repositoryDelete
        }
    }
}
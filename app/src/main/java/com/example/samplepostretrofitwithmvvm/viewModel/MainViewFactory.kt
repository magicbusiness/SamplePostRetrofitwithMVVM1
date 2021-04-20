package com.example.samplepostretrofitwithmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samplepostretrofitwithmvvm.repository.RepositoryData

class MainViewFactory(private val repositoryData: RepositoryData): ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return MainView(repositoryData) as T
    }
}
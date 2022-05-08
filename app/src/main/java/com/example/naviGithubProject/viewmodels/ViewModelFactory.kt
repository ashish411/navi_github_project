package com.example.naviGithubProject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naviGithubProject.network.NaviApiHelper
import com.example.naviGithubProject.network.NaviApiRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: NaviApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClosedPrViewModel::class.java))
            return ClosedPrViewModel(NaviApiRepository(apiHelper)) as T
        throw IllegalArgumentException("Unknown class error")
    }
}
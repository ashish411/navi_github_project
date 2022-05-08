package com.example.naviGithubProject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.naviGithubProject.network.ApiResponse
import com.example.naviGithubProject.network.NaviApiRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class ClosedPrViewModel(private val naviApiRepository: NaviApiRepository): ViewModel() {

    fun getClosedPrList() = liveData(Dispatchers.IO) {
        emit(ApiResponse.loading(null))
        try {
            emit(ApiResponse.success(naviApiRepository.getClosedPrList()))
        } catch (e: Exception){
            emit(ApiResponse.error(null,e.message.toString()))
        }
    }

}
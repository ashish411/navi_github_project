package com.example.naviGithubProject.network

class NaviApiHelper(private val apiService: NaviApiService) {

    suspend fun getClosedPrList() = apiService.getClosedPrList()
}
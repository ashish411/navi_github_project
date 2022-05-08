package com.example.naviGithubProject.network

class NaviApiRepository(private val apiHelper: NaviApiHelper) {

    suspend fun getClosedPrList() = apiHelper.getClosedPrList()
}
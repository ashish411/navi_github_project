package com.example.naviGithubProject.network

import retrofit2.http.GET

interface NaviApiService {

    @GET("repos/ashish411/navi_github_project/pulls?state=closed")
    suspend fun getClosedPrList(): List<NaviModel>

}
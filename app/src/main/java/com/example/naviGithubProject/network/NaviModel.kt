package com.example.naviGithubProject.network

import com.google.gson.annotations.SerializedName

data class NaviModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("created_at")
    val creationDate: String?,
    @SerializedName("closed_at")
    val closedDate: String?,
    @SerializedName("user")
    val user: User?
)

data class User(
    @SerializedName("login")
    val userName: String?,
    @SerializedName("avatar_url")
    val userImage: String?
)

package com.kotlin.kotlingithubbookmarks.retrofit

import com.kotlin.kotlingithubbookmarks.models.Repository
import com.kotlin.kotlingithubbookmarks.models.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface GithubAPIService {

    @GET("search/repositories")
    fun searchRepositories(@QueryMap options: Map<String, String>): Call<SearchResponse>

    @GET("/users/{username}/repos")
    fun searchRepositoriesByUser(@Path("username") githubUser: String): Call<List<Repository>>
}

// https://api.github.com/search/repositories?q=mario+language:kotlin

//https:api.github.com/users/jetbrains/repos
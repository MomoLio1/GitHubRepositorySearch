package com.example.gitlabrepositorysearch.api

import com.example.gitlabrepositorysearch.data.GithubResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val GET_REPOS: String = "search/repositories"

interface GithubApi {

    @Headers(
        "Accept: application/vnd.github.v3+json"
    )
    @GET(GET_REPOS)
    fun searchRepositories(@Query("q") q: String): Call<GithubResponse>

    @GET(GET_REPOS)
    fun searchRepositories(
        @Query("q") q: String,
        @Query("per_page") perPage: Int
    ): Call<GithubResponse>

    @GET(GET_REPOS)
    fun searchRepositories(
        @Query("q") searchQuery: String,
        @Query("page") pageIndex: Int,
        @Query("per_page") perPage: Int
    ): Call<GithubResponse>
}
package com.example.gitlabrepositorysearch.service

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import com.example.gitlabrepositorysearch.api.GithubApi
import com.example.gitlabrepositorysearch.config.ConfigurationClass
import com.example.gitlabrepositorysearch.data.GithubResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoService {

    //query github api
    fun getRepository(query: String, page: Int, perPage: Int) : MutableLiveData<GithubResponse> {
        val responseLiveData: MutableLiveData<GithubResponse> = MutableLiveData()

        val repositoryService = ConfigurationClass.retrofit.create(GithubApi::class.java)
        repositoryService.searchRepositories(query, page, perPage).enqueue(object : Callback<GithubResponse> {

            override fun onResponse(call: Call<GithubResponse>, response: Response<GithubResponse>) {
                if (response.code() == 200) {
                    Log.d(TAG, "Response: ${response.body()}")
                    responseLiveData.value = response.body() as GithubResponse
                } else {
                    Log.d(TAG, "Error: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                Log.e(TAG, "Failed to load")
            }
        })
        return responseLiveData
    }
}
package com.example.gitlabrepositorysearch.config

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigurationClass : Application() {
    companion object {
        // GitHub API URL
        const val URL = "https://api.github.com"

        //durch Retrofit kann ich die github API in einem Java interface verwandeln
        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        //Retrofit.Builder verwendet Builder-API, um URL-Endpunkt für HTTP-Operationen definieren
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

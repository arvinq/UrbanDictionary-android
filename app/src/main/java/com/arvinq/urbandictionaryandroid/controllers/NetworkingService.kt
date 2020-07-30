package com.arvinq.urbandictionaryandroid.controllers

import androidx.lifecycle.LiveData
import com.arvinq.urbandictionaryandroid.models.Term
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingService {

    // in here, instead of conforming to protocols, we create an
    // instance of our protocol and tagged it as a class.java
    val apiService: ApiService = Retrofit.Builder()
        .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()) //how we are decoding our data
        .build() //build out our factory
        .create(ApiService::class.java) //create an instance of apiService that will conform to our interface

    //we can just define a similar method much like the one in our apiService
    fun defineTerm(term: String): LiveData<List<Term>> {
        return object: LiveData<List<Term>>() {
            override fun onActive() { //observing an onActive event for LiveData
                super.onActive()

                //when it does become active
                //work in the background thread using Coroutine.
                //using IO will signify that we are on the background thread
                //DispatchQueue.global().async
                CoroutineScope(Dispatchers.IO).launch {
                    //user our apiService instance to call defineTerm and pass in the term typed by the user.
                    //once we get something from our apiService, we assign it to response variable
                    //response is of type DefineTermResponse ctrl shift p
                    val response = apiService.defineTerm(term)

                    // when we access the response's property, we need to be able to return to main thread
                    // so that when we add the value to ui we will not cause a crash.
                    //DispatchQueue.main.async
                    withContext(Dispatchers.Main) {
                        //LiveData has a property called value,
                        //since our LiveData is defined to have a List<Term>, value will be a list of terms
                        value = response.terms
                    }

                }
            }
        }
    }
}
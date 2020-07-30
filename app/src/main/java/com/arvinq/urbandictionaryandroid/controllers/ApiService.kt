package com.arvinq.urbandictionaryandroid.controllers

import com.arvinq.urbandictionaryandroid.models.DefineTermResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//protocol
interface ApiService {
//    "x-rapidapi-host": "mashape-community-urban-dictionary.p.rapidapi.com",
//	  "x-rapidapi-key": "fe77943feamsh8bb0a19bdec5f53p1c7cb0jsnd39137afbc2b"
//    https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=wat

    //escaping                         -> DefineTermResponse
    @Headers( //taking in an array hence ...value
        "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
        "x-rapidapi-key: fe77943feamsh8bb0a19bdec5f53p1c7cb0jsnd39137afbc2b"
    )
    @GET("define") //defined path in our url hence define. see url above
    suspend fun defineTerm(
        @Query("term")
        term: String //this is the value assigned to term in our url since term is a query
    ): DefineTermResponse
}
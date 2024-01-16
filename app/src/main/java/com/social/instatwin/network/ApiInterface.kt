package com.social.instatwin.network

import com.social.instatwin.data.models.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("character")
    suspend fun getCharacter() : Response<CharacterResponse>

}
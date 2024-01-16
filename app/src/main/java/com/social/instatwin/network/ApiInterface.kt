package com.social.instatwin.network

import com.social.instatwin.data.models.CharacterResponse
import com.social.instatwin.data.models.FeedResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("character")
    suspend fun getCharacter() : Response<CharacterResponse>

    @GET("feed")
    suspend fun getFeed() : Response<FeedResponse>
}
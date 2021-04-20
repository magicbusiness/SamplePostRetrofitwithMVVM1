package com.example.samplepostretrofitwithmvvm.network

import com.example.samplepostretrofitwithmvvm.model.ModuleRetro
import retrofit2.Response
import retrofit2.http.*

interface InterfaceRetro
{
    //
    @FormUrlEncoded
    @POST("posts")
    suspend fun sendPostForm(
        @Field("userId") userId: Int,
        @Field("id") id: Int,
        @Field("title") title: String,
        @Field("body") body: String
    ): Response<ModuleRetro>

    //
    @PUT("posts/{id}")
    suspend fun putPost(
//        @Path("id") number: Int,
        @Body post: ModuleRetro
    ): Response<ModuleRetro>

    //
    @PATCH("posts/{id}")
    suspend fun patchPost(
//        @Path("id") number: Int,
        @Body post: ModuleRetro
    ): Response<ModuleRetro>

    //
    @DELETE("posts/{id}")
    suspend fun deletePost(
        @Path("id") number: Int,
    ): Response<ModuleRetro>
}
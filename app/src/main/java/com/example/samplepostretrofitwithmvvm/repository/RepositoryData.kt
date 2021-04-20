package com.example.samplepostretrofitwithmvvm.repository

import com.example.samplepostretrofitwithmvvm.model.ModuleRetro
import com.example.samplepostretrofitwithmvvm.network.ObjectRetro
import retrofit2.Response

class RepositoryData
{
    //
    suspend fun postForm(userId: Int, id: Int, title: String, body: String): Response<ModuleRetro>
    {
        return ObjectRetro.getData.sendPostForm(userId, id, title, body)
    }

    //
    suspend fun postPut(post: ModuleRetro): Response<ModuleRetro>
    {
        return ObjectRetro.getData.putPost(post)
    }

    //
    suspend fun postPatch(post: ModuleRetro): Response<ModuleRetro>
    {
        return ObjectRetro.getData.patchPost(post)
    }

    //
    suspend fun postDelete(id: Int): Response<ModuleRetro>
    {
        return ObjectRetro.getData.deletePost(id)
    }
}
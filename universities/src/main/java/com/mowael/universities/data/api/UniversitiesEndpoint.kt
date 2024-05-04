package com.mowael.universities.data.api

import com.mowael.universities.data.model.UniversitiesResponse
import retrofit2.http.GET

interface UniversitiesEndpoint {

    @GET
    suspend fun getUniversities(): UniversitiesResponse
}
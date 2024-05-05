package com.mowael.universities.data.api

import com.mowael.universities.data.model.UniversitiesResponse
import com.mowael.universities.data.model.UniversityItem
import retrofit2.http.GET

interface UniversitiesEndpoint {

    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversities(): List<UniversityItem>
}
package com.mowael.universities.data.repo

import com.mowael.universities.data.api.UniversitiesEndpoint
import com.mowael.universities.data.model.UniversitiesResponse
import javax.inject.Inject

class UniversitiesRepoImpl @Inject constructor(private val endpoint: UniversitiesEndpoint) : UniversitiesRepo {
    override suspend fun getUniversities(): UniversitiesResponse {

        return endpoint.getUniversities()
    }
}
package com.mowael.universities.data.repo

import com.mowael.universities.data.model.UniversitiesResponse

interface UniversitiesRepo {
    suspend fun getUniversities(): UniversitiesResponse
}
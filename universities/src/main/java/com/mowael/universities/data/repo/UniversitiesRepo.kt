package com.mowael.universities.data.repo

import com.mowael.core.data.UniversityDto
import com.mowael.universities.data.model.UniversitiesResponse
import com.mowael.universities.data.model.UniversityItem

interface UniversitiesRepo {
    suspend fun getUniversities(): List<UniversityDto>
}
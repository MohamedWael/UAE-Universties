package com.mowael.universities.domain

import com.mowael.core.data.UniversityDto
import com.mowael.universities.data.model.UniversitiesResponse
import com.mowael.universities.data.model.UniversityItem

interface UniversitiesUseCase {
    suspend fun getUniversities(): List<UniversityDto>
}
package com.mowael.universities.domain

import com.mowael.core.data.UniversityDto
import com.mowael.universities.data.model.UniversityItem
import com.mowael.universities.data.repo.UniversitiesRepo
import javax.inject.Inject

class UniversitiesUseCaseImpl @Inject constructor(
    private val repo: UniversitiesRepo
) : UniversitiesUseCase {
    override suspend fun getUniversities(): List<UniversityDto> = repo.getUniversities()

}

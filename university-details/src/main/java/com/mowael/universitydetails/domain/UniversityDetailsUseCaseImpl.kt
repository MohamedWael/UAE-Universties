package com.mowael.universitydetails.domain

import com.mowael.core.data.UniversityDto
import com.mowael.universitydetails.data.UniversityDetailsRepo
import javax.inject.Inject

class UniversityDetailsUseCaseImpl @Inject constructor(private val repo: UniversityDetailsRepo) :
    UniversityDetailsUseCase {
    override suspend fun getUniversityById(id: Long): UniversityDto? = repo.getUniversityById(id)
    override suspend fun getUniversityByName(name: String): UniversityDto? = repo.getUniversityByName(name)

}

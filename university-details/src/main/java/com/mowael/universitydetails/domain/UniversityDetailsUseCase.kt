package com.mowael.universitydetails.domain

import com.mowael.core.data.UniversityDto

interface UniversityDetailsUseCase {

    suspend fun getUniversityById(id: Long): UniversityDto?
    suspend fun getUniversityByName(name: String): UniversityDto?
}
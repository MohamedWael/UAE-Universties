package com.mowael.universitydetails.data

import com.mowael.core.data.UniversityDto

interface UniversityDetailsRepo {

    suspend fun getUniversityById(id: Long): UniversityDto?
    suspend fun getUniversityByName(name: String): UniversityDto?
}
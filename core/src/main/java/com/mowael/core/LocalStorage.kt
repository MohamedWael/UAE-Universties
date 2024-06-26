package com.mowael.core

import com.mowael.core.data.UniversityDto

interface LocalStorage {
    suspend fun insertUniversities(universities: List<UniversityDto>)

    suspend fun getUniversities(): List<UniversityDto>
    suspend fun getUniversityById(id: Long): UniversityDto?
    suspend fun getUniversityByName(name: String): UniversityDto?

    suspend fun deleteAllUniversities()


}
package com.mowael.universitydetails.data

import com.mowael.core.LocalStorage
import com.mowael.core.data.UniversityDto
import javax.inject.Inject

class UniversityDetailsRepoImpl @Inject constructor(private val localStorage: LocalStorage) :
    UniversityDetailsRepo {
    override suspend fun getUniversityById(id: Long): UniversityDto? {
        return localStorage.getUniversityById(id)
    }

    override suspend fun getUniversityByName(name: String): UniversityDto? {
        return localStorage.getUniversityByName(name)
    }
}

package com.mowael.universities.data.repo

import com.mowael.core.LocalStorage
import com.mowael.core.data.UniversityDto
import com.mowael.universities.data.api.UniversitiesEndpoint
import com.mowael.universities.data.model.UniversitiesResponse
import com.mowael.universities.data.model.UniversityItem
import com.mowael.universities.data.model.toUniversityItem
import javax.inject.Inject

class UniversitiesRepoImpl @Inject constructor(
    private val endpoint: UniversitiesEndpoint,
    private val localStorage: LocalStorage
) : UniversitiesRepo {
    override suspend fun getUniversities(): List<UniversityDto> {
        return  try {
            val universities = endpoint.getUniversities()
            localStorage.deleteAllUniversities()
            localStorage.insertUniversities(universities.map { it.toDto() })
            localStorage.getUniversities()
        } catch (e:Throwable){
            localStorage.getUniversities()
        }
    }
}

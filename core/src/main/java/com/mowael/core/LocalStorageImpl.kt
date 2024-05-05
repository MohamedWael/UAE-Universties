package com.mowael.core

import com.mowael.core.data.UniversityDto
import javax.inject.Inject

class LocalStorageImpl @Inject constructor(
    db: AppDatabase
) : LocalStorage {

    private val universityDao = db.universityDao()
    override suspend fun insertUniversities(universities: List<UniversityDto>) =
        universityDao.insertUniversities(*universities.toTypedArray())


    override suspend fun getUniversities(): List<UniversityDto> = universityDao.getAllUniversities()

    override suspend fun getUniversityById(id: Long): UniversityDto? =
        universityDao.getUniversityById(id)

    override suspend fun getUniversityByName(name: String): UniversityDto? =
        universityDao.getUniversityByName(name)

    override suspend fun deleteAllUniversities() = universityDao.deleteAll()

}

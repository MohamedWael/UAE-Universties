package com.mowael.core

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mowael.core.data.UniversityDto


@Dao
interface UniversityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(vararg universities: UniversityDto)

    @Query("SELECT * FROM UniversityDto WHERE name = :name")
    suspend fun getUniversityByName(name: String): UniversityDto?

    @Query("SELECT * FROM UniversityDto WHERE name = :id")
    suspend fun getUniversityById(id: Long): UniversityDto?

    @Query("SELECT * FROM UniversityDto")
    suspend fun getAllUniversities(): List<UniversityDto>

    @Query("Delete FROM UniversityDto")
    suspend fun deleteAll()
}

package com.mowael.core

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mowael.core.data.UniversityDto


@Dao
interface UniversityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversity(university: UniversityDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(vararg universities: UniversityDto)

    @Query("SELECT * FROM UniversityDto WHERE name = :name")
    suspend fun getUniversityByName(name: String): UniversityDto

    @Query("SELECT * FROM UniversityDto")
    suspend fun getAllUniversities(): List<UniversityDto>

    @Query("SELECT * FROM UniversityDto")
    fun getAllUniversitiesLive(): LiveData<List<UniversityDto>>

    @Query("Delete FROM UniversityDto")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(university: UniversityDto)
}

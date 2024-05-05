package com.mowael.core.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class UniversityDto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val country: String? = null,
    @field:TypeConverters(ListTypeConverter::class)
    val webPages: List<String>? = null,
    val name: String? = null,
    @field:TypeConverters(ListTypeConverter::class)
    val domains: List<String>? = null,
    val alphaTwoCode: String? = null,
    val stateProvince: String? = null
)
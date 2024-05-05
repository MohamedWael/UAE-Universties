package com.mowael.universities.presentation

import com.mowael.core.data.UniversityDto
import com.mowael.universities.data.model.UniversityItem

sealed class UniversitiesState {

    data object Idle : UniversitiesState()
    data object Loading : UniversitiesState()
    data class Success(val universities: List<UniversityDto>) : UniversitiesState()
    data class Error(val error: Throwable) : UniversitiesState()
}
package com.mowael.universitydetails.presentation

import com.mowael.core.data.UniversityDto

sealed class UniversityDetailsState {

    data object Loading : UniversityDetailsState()

    data class Error(val error: Throwable) : UniversityDetailsState()

    data class Success(val university: UniversityDto?) : UniversityDetailsState()

}
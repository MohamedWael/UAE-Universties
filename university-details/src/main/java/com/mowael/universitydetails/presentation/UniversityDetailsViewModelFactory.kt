package com.mowael.universitydetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mowael.universitydetails.domain.UniversityDetailsUseCase
import javax.inject.Inject


class UniversityDetailsViewModelFactory @Inject constructor(private val useCase: UniversityDetailsUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        if (modelClass.isAssignableFrom(UniversityDetailsViewModel::class.java)) {
            return UniversityDetailsViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

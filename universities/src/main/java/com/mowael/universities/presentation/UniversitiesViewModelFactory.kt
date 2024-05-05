package com.mowael.universities.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mowael.universities.domain.UniversitiesUseCase
import javax.inject.Inject


class UniversitiesViewModelFactory @Inject constructor (private val useCase: UniversitiesUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("unchecked_cast")
        if (modelClass.isAssignableFrom(UniversitiesViewModel::class.java)) {
            return UniversitiesViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

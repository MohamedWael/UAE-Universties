package com.mowael.universities.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mowael.universities.domain.UniversitiesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversitiesViewModel @Inject constructor(
    private val useCase: UniversitiesUseCase
) : ViewModel() {


    private val _universitiesLiveData = MutableLiveData<UniversitiesState>()
    val universitiesLiveData: LiveData<UniversitiesState> = _universitiesLiveData

    init {
        getUniversities()
    }

    fun getUniversities() = viewModelScope.launch {
        _universitiesLiveData.value = UniversitiesState.Loading
        try {
            _universitiesLiveData.value = UniversitiesState.Success(useCase.getUniversities())
        } catch (e: Throwable) {
            _universitiesLiveData.value = UniversitiesState.Error(e)
        }

    }
}
package com.mowael.universitydetails.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mowael.universitydetails.domain.UniversityDetailsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversityDetailsViewModel @Inject constructor(
    private val useCase: UniversityDetailsUseCase
) : ViewModel() {


    private val _universitiesLiveData = MutableLiveData<UniversityDetailsState>()
    val universitiesLiveData: LiveData<UniversityDetailsState> = _universitiesLiveData

    fun getUniversityById(id: Long) {
        viewModelScope.launch {
            _universitiesLiveData.value = UniversityDetailsState.Loading
            try {
                _universitiesLiveData.value =
                    UniversityDetailsState.Success(useCase.getUniversityById(id))

            } catch (e: Exception) {
                _universitiesLiveData.value = UniversityDetailsState.Error(e)
            }
        }
    }

    fun getUniversityByName(name: String) {
        viewModelScope.launch {
            _universitiesLiveData.value = UniversityDetailsState.Loading
            try {
                _universitiesLiveData.value =
                    UniversityDetailsState.Success(useCase.getUniversityByName(name))

            } catch (e: Exception) {
                _universitiesLiveData.value = UniversityDetailsState.Error(e)
            }
        }
    }
}

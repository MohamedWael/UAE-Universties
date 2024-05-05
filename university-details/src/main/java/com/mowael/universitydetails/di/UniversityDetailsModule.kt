package com.mowael.universitydetails.di

import com.mowael.core.LocalStorage
import com.mowael.core.di.AppModule
import com.mowael.universitydetails.data.UniversityDetailsRepo
import com.mowael.universitydetails.data.UniversityDetailsRepoImpl
import com.mowael.universitydetails.domain.UniversityDetailsUseCase
import com.mowael.universitydetails.domain.UniversityDetailsUseCaseImpl
import com.mowael.universitydetails.presentation.UniversityDetailsViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [AppModule::class])
class UniversityDetailsModule {

    @Provides
    fun provideUniversityDetailsRepo(localStorage: LocalStorage): UniversityDetailsRepo =
        UniversityDetailsRepoImpl(localStorage)

    @Provides
    fun provideUniversityDetailsUseCase(universityDetailsRepo: UniversityDetailsRepo): UniversityDetailsUseCase =
        UniversityDetailsUseCaseImpl(universityDetailsRepo)


    @Provides
    fun provideUniversityDetailsViewModelFactory(universitiesUseCase: UniversityDetailsUseCase): UniversityDetailsViewModelFactory =
        UniversityDetailsViewModelFactory(universitiesUseCase)
}
package com.mowael.universitydetails.di

import android.app.Application
import com.mowael.core.di.AppModule
import com.mowael.universitydetails.presentation.UniversityDetailsViewModelFactory
import com.mowael.universitydetails.view.UniversityDetailsFragment
import dagger.Component

@Component(modules = [UniversityDetailsModule::class])
interface UniversityDetailsComponent {

    companion object {
        fun create(app:Application): UniversityDetailsComponent = DaggerUniversityDetailsComponent.builder().
            universityDetailsModule(UniversityDetailsModule()).appModule(AppModule(app))
                .build()
    }

    fun inject(universityDetailsFragment: UniversityDetailsFragment)
    fun universityDetailsViewModelFactory(): UniversityDetailsViewModelFactory

}